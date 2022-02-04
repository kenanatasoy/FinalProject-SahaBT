package com.example.bookstoremicroservice.category.service;

import com.example.bookstoremicroservice.category.dto.response.GetCategoryResponse;
import com.example.dto.response.DeleteCategoryResponse;

public interface CategoryService {
    GetCategoryResponse addCategory(int categoryId);

    DeleteCategoryResponse deleteCategory(int categoryId);
}
