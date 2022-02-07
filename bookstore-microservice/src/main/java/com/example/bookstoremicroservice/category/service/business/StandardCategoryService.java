package com.example.bookstoremicroservice.category.service.business;

import com.example.application.CategoryApplication;
import com.example.application.business.exception.BookNotFoundException;
import com.example.application.business.exception.CategoryNotFoundException;
import com.example.bookstoremicroservice.catalog.dto.response.GetBookResponse;
import com.example.bookstoremicroservice.category.dto.request.AddCategoryRequest;
import com.example.bookstoremicroservice.category.dto.response.AddedCategoryResponse;
import com.example.bookstoremicroservice.category.dto.response.CategoryResponse;
import com.example.bookstoremicroservice.category.service.CategoryService;
import com.example.bookstoremicroservice.category.dto.response.GetCategoryResponse;
import com.example.bookstoremicroservice.sale.dto.response.MakeSaleResponse;
import com.example.bookstoremicroservice.sale.dto.response.SaleResponse;

import com.example.domain.category.Category;
import com.example.domain.category.CategoryId;

import com.example.repository.CategoryRepository;
import com.example.sale.application.business.exception.SaleNotFoundException;
import com.example.sale.domain.Sale;
import com.example.sale.domain.SaleId;
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
    public CategoryResponse getCategoryByCategoryId(int categoryId) {
        var category = categoryApplication.getCategoryById(CategoryId.valueOf(categoryId));
        if (category==null)
            throw new CategoryNotFoundException("Cannot find category",categoryId);
        return modelMapper.map(category, CategoryResponse.class);

    }

    @Override
    public List<CategoryResponse> getAllCatagories() {

        var category= categoryApplication.listCategories();
        return category.stream()
                .map((s) -> modelMapper.map(s,CategoryResponse.class)).toList();
    }

    @Override
    public AddedCategoryResponse addCategory(AddCategoryRequest request) {
        var category=modelMapper.map(request, Category.class);
        var addedCategory=categoryApplication.addCategory(category);
        return modelMapper.map(addedCategory, AddedCategoryResponse.class);
    }
}
