package com.example.application;

import com.example.domain.book.Book;
import com.example.domain.book.Isbn;

import java.util.Optional;

public interface BookApplication {
    Book addBook(Book book);
    Book deleteBook(Isbn isbn);
    Optional


}
