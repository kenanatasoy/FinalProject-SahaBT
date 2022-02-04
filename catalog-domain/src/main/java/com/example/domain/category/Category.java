package com.example.domain.category;

import java.util.Objects;

public class Category {
    private CategoryId categoryId;
    private Name name;
    private Category subCategory;

    public Category() {
    }

    public Category(CategoryId id) {
        this.categoryId = id;
    }

    public CategoryId getId() {
        return categoryId;
    }

    public void setId(CategoryId id) {
        this.categoryId = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Category getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(Category subCategory) {
        this.subCategory = subCategory;

        //cacheleme
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + categoryId +
                ", name=" + name +
                ", subCategory=" + subCategory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryId, category.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId);
    }
}
