package com.example.domain.category;

import java.util.Objects;

public class Category {
    private CategoryId id;
    private Name name;
    private Category subCategory;

    public static class Builder{
        private CategoryId id;
        private Name name;
        private Category subCategory;

        public Builder id(int categoryId) {
            this.id = CategoryId.valueOf(categoryId);
            return this;
        }

        public Builder name(String categoryName) {
            this.name = Name.of(categoryName);
            return this;
        }
        public Builder subCategory(Category name) {
            this.subCategory = name.subCategory;
            return this;
        }

        public Category build(){
            var category = new Category(this.id);
            category.setName(name);
            category.setSubCategory(subCategory);

        return category;
        }

    }

    public Category(CategoryId id) {
        this.id = id;
    }

    public CategoryId getId() {
        return id;
    }

    public void setId(CategoryId id) {
        this.id = id;
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
        this.subCategory = subCategory.name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name=" + name +
                ", subCategory=" + subCategory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
