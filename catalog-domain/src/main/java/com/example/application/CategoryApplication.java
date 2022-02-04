package com.example.application;

import com.example.domain.category.Category;
import com.example.domain.category.CategoryId;

import java.util.List;

public interface CategoryApplication {


    Category getCategoryById(CategoryId categoryId);
    Category addCategory(Category category);
    List<Category> listCategories();

}
