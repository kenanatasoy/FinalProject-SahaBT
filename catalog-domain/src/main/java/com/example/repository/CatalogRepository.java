package com.example.repository;

import com.example.category.domain.Category;
import com.example.category.domain.CategoryId;
import com.example.category.domain.SubCategory;
import com.example.domain.book.Book;
import com.example.domain.book.Isbn;

import java.util.List;
import java.util.Optional;

public interface CatalogRepository {
    boolean existByIsbn(Isbn isbn);

    Book save(Book book);

    Optional<Book> delete(Isbn isbn);

    Optional<Category> findCategoryById(CategoryId categoryId);
    Category addCategory(Category category);
    SubCategory addSubCategory(SubCategory subCategory);
    List<Category> listCategories();
    List<SubCategory> listSubCategories();
    List<SubCategory> listSubCategoriesByCategoryId(CategoryId categoryId);
    Boolean existByCategoryId(CategoryId categoryId);


}
