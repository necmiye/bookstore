package com.bookstore.bookstore.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BookDto {
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private double price;
    private int stockQuantity;
    private Date createdAt;
    private Date updatedAt;

    public BookDto(Long id, String isbn, String title, String author,
                   double price, int stockQuantity, Date createdAt, Date updatedAt) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
