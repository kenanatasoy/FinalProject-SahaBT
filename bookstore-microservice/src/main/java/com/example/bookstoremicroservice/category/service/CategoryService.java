package com.example.bookstoremicroservice.category.service;

import com.example.bookstoremicroservice.category.dto.response.CategoryResponse;
import com.example.bookstoremicroservice.category.dto.response.GetCategoryResponse;
import com.example.domain.category.Category;
import com.example.dto.response.DeleteCategoryResponse;

import java.util.List;

public interface CategoryService {
    GetCategoryResponse addCategory(Category category);

    CategoryResponse getCategoryByCategoryId(int categoryId);

    List<CategoryResponse> getAllCatagories();
}
