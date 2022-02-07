package com.example.bookstoremicroservice.category.service.business;

import com.example.application.CategoryApplication;
import com.example.application.business.exception.BookNotFoundException;
import com.example.application.business.exception.CategoryNotFoundException;
import com.example.bookstoremicroservice.catalog.dto.response.GetBookResponse;
import com.example.bookstoremicroservice.category.dto.request.AddCategoryRequest;
import com.example.bookstoremicroservice.category.dto.response.CategoryResponse;
import com.example.bookstoremicroservice.category.service.CategoryService;
import com.example.bookstoremicroservice.category.dto.response.GetCategoryResponse;
import com.example.controller.dto.request.AddCategoryRequest;
import com.example.domain.category.Category;
import com.example.dto.response.DeleteCategoryResponse;
import com.example.repository.CategoryRepository;
import com.example.shared.domain.Isbn;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardCategoryService implements CategoryService {
    private CategoryApplication categoryApplication;
    private ModelMapper modelMapper;

    public StandardCategoryService(CategoryApplication categoryApplication, ModelMapper modelMapper) {
        this.categoryApplication = categoryApplication;
        this.modelMapper = modelMapper;
    }

    @Override
    public GetCategoryResponse addCategory(AddCategoryRequest request) {
        var category = categoryApplication.addCategory(request);
        if(category.equals(null))
            throw  new CategoryNotFoundException("Cannot Find Book",categoryId);
        return  modelMapper.map(category , GetCategoryResponse.class);
    }


    @Override
    public CategoryResponse getCategoryByCategoryId(int categoryId) {
        return null;
    }

    @Override
    public List<CategoryResponse> getAllCatagories() {
        return null;
    }
}
