package com.example.application;

import com.example.domain.book.Author;
import com.example.domain.book.Book;
import com.example.domain.book.Isbn;
import com.example.domain.book.Title;

import java.util.List;
import java.util.Optional;

public interface BookApplication {
    Book addBook(Book book);
    Book deleteBook(Isbn isbn);
    Optional<Book> findBookByIsbn(Isbn isbn);
    List<Book> findByAuthor(Author author);
    List<Book> findByTitle(Title title);



}
