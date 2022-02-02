package com.example.repository;


import com.example.domain.book.Book;
import com.example.domain.category.Category;
import com.example.domain.category.CategoryId;
import com.example.shared.domain.Isbn;

import java.util.List;
import java.util.Optional;

public interface CatalogRepository {
    boolean existBookByIsbn(Isbn isbn);

    Book save(Book book);

    Optional<Book> delete(Isbn isbn);

    Optional<Book> findByID(Isbn isbn);

    List<Book> findBooksByCategoryId(CategoryId categoryId);










}
