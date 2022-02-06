package com.example.bookstoremicroservice.category.service.business;

import com.example.bookstoremicroservice.category.dto.response.CategoryResponse;
import com.example.bookstoremicroservice.category.service.CategoryService;
import com.example.bookstoremicroservice.category.dto.response.GetCategoryResponse;
import com.example.dto.response.DeleteCategoryResponse;
import org.springframework.stereotype.Service;

@Service
public class StandardCategoryService implements CategoryService {
    @Override
    public GetCategoryResponse addCategory(int categoryId) {
        return null;
    }


    @Override
    public CategoryResponse getCategoryByCategoryId(int categoryId) {
        return null;
    }
}
