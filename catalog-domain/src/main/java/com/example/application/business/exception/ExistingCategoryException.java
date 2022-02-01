package com.example.application.business.exception;

public class ExistingCategoryException extends RuntimeException {
    private final int categoryID;

    public  ExistingCategoryException(String message ,int categoryID) {
        super(message);
        this.categoryID = categoryID;
    }

    public int getCategoryID() {
        return categoryID;
    }
}
