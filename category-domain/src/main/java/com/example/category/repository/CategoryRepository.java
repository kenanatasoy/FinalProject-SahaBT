package com.example.category.repository;

import com.example.category.domain.Category;
import com.example.category.domain.CategoryId;
import com.example.category.domain.SubCategory;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
   Optional<Category> findCategoryById(CategoryId categoryId);
   Category addCategory(Category category);
   SubCategory addSubCategory(SubCategory subCategory);
   List<Category> listCategories();
   List<SubCategory> listSubCategories();
   List<SubCategory> listSubCategoriesByCategoryId(CategoryId categoryId);
   Boolean existByCategoryId(CategoryId categoryId);

}
