package com.example.application;


import com.example.domain.book.Book;
import com.example.domain.category.Category;
import com.example.domain.category.CategoryId;
import com.example.shared.domain.Isbn;

import java.util.List;
import java.util.Optional;

public interface CatalogApplication {
    Book addBook(Book book,int amount);
    Book deleteBook(Isbn isbn);
    Optional<Book> findBookByIsbn(Isbn isbn);
    List<Book> findByCategoryId(CategoryId categoryId);



}
