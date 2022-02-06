package com.example.bookstoremicroservice.category.service;

import com.example.bookstoremicroservice.category.dto.response.CategoryResponse;
import com.example.bookstoremicroservice.category.dto.response.GetCategoryResponse;
import com.example.dto.response.DeleteCategoryResponse;

import java.util.List;

public interface CategoryService {
    GetCategoryResponse addCategory(int categoryId);

    CategoryResponse getCategoryByCategoryId(int categoryId);

    List<CategoryResponse> getAllCatagories();
}
