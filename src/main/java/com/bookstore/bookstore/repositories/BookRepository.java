package com.bookstore.bookstore.repositories;

import com.bookstore.bookstore.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findAllByOrderByCreatedAtDesc();
    List<Book> findAll();
    Optional<Book> findById(Long id);
    List<Book> findByIsbnIn(List<String> isbnList);
    Optional<Book> findByIsbn(String isbn);
}
