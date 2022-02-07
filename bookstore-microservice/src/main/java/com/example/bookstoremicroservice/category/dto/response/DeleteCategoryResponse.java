package com.example.bookstoremicroservice.category.dto.response;

public class DeleteCategoryResponse {
    private int categoryId;
    private String name;

    public DeleteCategoryResponse() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
