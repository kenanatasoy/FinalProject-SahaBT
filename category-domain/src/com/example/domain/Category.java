package com.example.domain;

import java.util.Objects;

public class Category {
    private Id id;
    private Name name;
    private SubCategory subCategory;

    public static class Builder{
        private Id id;
        private Name name;
        private SubCategory subCategory;

        public Builder id(int categoryId) {
            this.id = Id.valueOf(categoryId);
            return this;
        }

        public Builder name(String categoryName) {
            this.name = Name.of(categoryName);
            return this;
        }
        public Builder subCategory(String subCategoryName) {
            this.subCategory = SubCategory.of(subCategoryName);
            return this;
        }

        public Category build(){
            var category = new Category(this.id);
            category.setName(name);
            category.setSubCategory(subCategory);

        return category;
        }

    }

    public Category(Id id) {
        this.id = id;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
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
