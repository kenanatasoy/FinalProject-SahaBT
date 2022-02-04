package com.example.bookstoremicroservice.category.service;

import com.example.bookstoremicroservice.category.dto.response.GetCategoryResponse;

public interface CategoryService {
    GetCategoryResponse addCategory(int categoryId);
}
