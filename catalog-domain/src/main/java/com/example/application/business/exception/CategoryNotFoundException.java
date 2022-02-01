package com.example.application.business.exception;

public class CategoryNotFoundException extends RuntimeException {

    private final int categoryID;

    public  CategoryNotFoundException(String message ,int categoryID) {
        super(message);
        this.categoryID = categoryID;
    }

    public int getCategoryID() {
        return categoryID;
    }
}
