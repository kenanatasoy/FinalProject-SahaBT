package com.example.application;

import com.example.category.domain.Category;
import com.example.category.domain.CategoryId;
import com.example.category.domain.SubCategory;
import com.example.domain.book.Book;

import java.util.List;
import java.util.Optional;

public interface CatalogApplication {
    Book addBook(Book book);
    Book deleteBook(Isbn isbn);
    Optional<Book> findBookByIsbn(Isbn isbn);
    List<Book> findByCategoryId(CategoryId categoryId);

    Category getCategoryById(CategoryId categoryId);
    Category addCategory(Category category);
    SubCategory addSubCategory(Category subCategory);
    List<Category> listCategories();
    List<SubCategory> listSubCategories();
    List<SubCategory> listSubCategoriesByCategoryId(CategoryId categoryId);


}
