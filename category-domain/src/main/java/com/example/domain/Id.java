package com.example.domain;

public class Id {
    private final int categoryId;

    private Id(int categoryId) {
        this.categoryId = categoryId;
    }
    public static Id valueOf(int categoryId){
        return new Id(categoryId);
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
