package com.bookstore.bookstore.dto;

import com.bookstore.bookstore.entities.Book;
import com.bookstore.bookstore.entities.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class OrderDto {
    private Long orderId;
    private User user;
    private double totalPrice;
    private List<Book> books;
    private List<String> isbnList;
    private LocalDateTime orderDate;
    private Date createdAt;
    private Date updatedAt;

    public OrderDto(Long orderId, User user, double totalPrice, List<Book> books,
                    LocalDateTime orderDate, Date createdAt, Date updatedAt) {
        this.orderId = orderId;
        this.user = user;
        this.totalPrice = totalPrice;
        this.books = books;
        this.orderDate = orderDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
