package com.bookstore.bookstore.services;

import com.bookstore.bookstore.entities.Book;
import com.bookstore.bookstore.repositories.BookRepository;
import com.bookstore.bookstore.exception.BookNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllBooksOrderedByCreationDateDesc() {
        return bookRepository.findAllByOrderByCreatedAtDesc();
    }
    @Override
    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException("Book not found with ISBN: " + isbn));
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(String isbn, Book updatedBook) {
        Book existingBook = getBookByIsbn(isbn);
        return bookRepository.save(existingBook);
    }
    @Override
    public void deleteBook(String isbn) {
        Book existingBook = getBookByIsbn(isbn);
        bookRepository.delete(existingBook);
    }

    @Override
    public List<Book> getBooksByIsbnList(List<String> isbnList) {
        return bookRepository.findByIsbnIn(isbnList);
    }
}
