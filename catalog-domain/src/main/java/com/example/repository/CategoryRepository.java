package com.example.repository;

import com.example.domain.category.Category;
import com.example.domain.category.CategoryId;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    boolean existCategoryByCategoryId(CategoryId categoryId);

    Category saveCategory(Category category);

    Optional<Category> findCategoryById(CategoryId categoryId);

    List<Category> listCategories();
}
