package com.example.repository;

import com.example.domain.book.Book;
import com.example.domain.book.Isbn;

public interface BookRepository {
    boolean existByIsbn(Isbn isbn);

    Book save(Book book);
}
