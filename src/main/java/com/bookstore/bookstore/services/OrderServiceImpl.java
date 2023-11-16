package com.bookstore.bookstore.services;

import com.bookstore.bookstore.dto.OrderDto;
import com.bookstore.bookstore.dto.UserDto;
import com.bookstore.bookstore.entities.Book;
import com.bookstore.bookstore.entities.Order;
import com.bookstore.bookstore.entities.User;
import com.bookstore.bookstore.exception.MinimumOrderAmountException;
import com.bookstore.bookstore.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    private OrderRepository orderRepository;
    private IUserService userService;
    private IBookService bookService;
    @Override
    public Order placeOrder(OrderDto orderRequest) {
        User user = userService.getUserById(orderRequest.getUser().getId());
        List<Book> books = bookService.getBooksByIsbnList(orderRequest.getIsbnList());
        double totalAmount = books.stream().mapToDouble(Book::getPrice).sum();
        if (totalAmount < 25) {
            throw new MinimumOrderAmountException("Minimum order amount should be 25$.");
        }
        Order order = new Order();
        order.setUser(user);
        order.setBooks(books);
        order.setTotalPrice(totalAmount);
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }
    @Override
    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByUserIdOrderByUpdatedAtDesc(userId);
    }

}
