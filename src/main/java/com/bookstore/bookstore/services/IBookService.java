package com.bookstore.bookstore.services;

import com.bookstore.bookstore.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookService {
    List<Book> getAllBooksOrderedByCreationDateDesc();
    Book getBookByIsbn(String isbn);
    Book addBook(Book book);
    Book updateBook(String isbn, Book updatedBook);

    void deleteBook(String isbn);

    List<Book> getBooksByIsbnList(List<String> isbnList);
}
