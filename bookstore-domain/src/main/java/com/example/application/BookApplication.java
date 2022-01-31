package com.example.application;

import com.example.sale.book.Book;
import com.example.sale.book.Isbn;

import java.util.Optional;

public interface BookApplication {
    Book addBook(Book book);
    Book deleteBook(Isbn isbn);
    Optional


}
