package com.example.bookstoremicroservice.service;

import com.example.bookstoremicroservice.dto.response.GetCategoryResponse;

public interface CategoryService {
    GetCategoryResponse addCategory(int categoryId);
}
