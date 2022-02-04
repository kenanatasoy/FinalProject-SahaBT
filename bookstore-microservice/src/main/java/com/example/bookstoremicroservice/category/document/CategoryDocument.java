package com.example.bookstoremicroservice.category.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "category")
public class CategoryDocument {
    @Id
    private  int categoryId;
    private  String name;
    //Sub category categry cinsinden nasıl olacak
    //List of categoymi olacak
    private  String category;

    public CategoryDocument() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public CategoryDocument setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryDocument setName(String name) {
        this.name = name;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public CategoryDocument setCategory(String category) {
        this.category = category;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDocument that = (CategoryDocument) o;
        return categoryId == that.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId);
    }

    @Override
    public String toString() {
        return "CategoryDocument{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
