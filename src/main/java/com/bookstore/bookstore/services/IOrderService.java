package com.bookstore.bookstore.services;

import com.bookstore.bookstore.dto.OrderDto;
import com.bookstore.bookstore.entities.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService {
    Order placeOrder(OrderDto orderRequest);
    List<Order> getUserOrders(Long userId);

   // OrderDetails getOrderDetails(Long orderId);
}
