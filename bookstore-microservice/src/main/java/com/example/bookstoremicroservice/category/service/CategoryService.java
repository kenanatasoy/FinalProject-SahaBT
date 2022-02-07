package com.example.bookstoremicroservice.category.service;

import com.example.bookstoremicroservice.category.dto.request.AddCategoryRequest;
import com.example.bookstoremicroservice.category.dto.response.AddedCategoryResponse;
import com.example.bookstoremicroservice.category.dto.response.CategoryResponse;
import com.example.bookstoremicroservice.category.dto.response.GetCategoryResponse;
import com.example.domain.category.Category;


import java.util.List;

public interface CategoryService {
  

    CategoryResponse getCategoryByCategoryId(int categoryId);

    List<CategoryResponse> getAllCatagories();

    AddedCategoryResponse addCategory(AddCategoryRequest request);
}
