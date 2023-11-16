package com.bookstore.bookstore.dto;

import com.bookstore.bookstore.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDtoConverter {
    public BookDto convert (Book book){
        return new BookDto(
                book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getPrice(),
                book.getStockQuantity(),
                book.getCreatedAt(),
                book.getUpdatedAt());
    }
}
