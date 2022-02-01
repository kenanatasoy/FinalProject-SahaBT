package com.example.domain.category;

public class CategoryId {
    private final int categoryId;

    private CategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public static CategoryId valueOf(int categoryId){
        return new CategoryId(categoryId);
    }

    public int getCategoryId() {
        return categoryId;
    }

    @Override
    public String toString() {
        return "Id{" +
                "categoryId=" + categoryId +
                '}';
    }
}
