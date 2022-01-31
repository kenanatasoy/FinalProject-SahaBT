package com.example.category.service.business;

import com.example.category.domain.Category;
import com.example.category.domain.CategoryId;
import com.example.category.domain.SubCategory;
import com.example.category.repository.CategoryRepository;
import com.example.category.service.CategoryService;
import com.example.category.service.business.exception.CategoryNotFoundException;
import com.example.category.service.business.exception.ExistingCategoryException;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryById(CategoryId categoryId) {
        return categoryRepository.findCategoryById(categoryId).orElseThrow(()
                -> new CategoryNotFoundException("Category not found", categoryId.getCategoryId()));
    }

    @Override
    public Category addCategory(Category category) {
        if (categoryRepository.existByCategoryId(category.getId()))
            throw new ExistingCategoryException("Category already exist",category.getId().getCategoryId());
        return categoryRepository.addCategory(category);
    }

    @Override
    public SubCategory addSubCategory(SubCategory subCategory) {

        return null;
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.listCategories();
    }

    @Override
    public List<SubCategory> listSubCategories() {
        return categoryRepository.listSubCategories();
    }

    @Override
    public List<SubCategory> listSubCategoriesByCategoryId(CategoryId categoryId) {
        return categoryRepository.listSubCategoriesByCategoryId(categoryId);
    }
}
