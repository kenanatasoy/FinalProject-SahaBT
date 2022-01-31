package com.example.category.service.business.exception;
@SuppressWarnings("serial")
public class CategoryNotFoundException extends RuntimeException {

    private final int identity;

    public CategoryNotFoundException(String message, int identity) {
        super(message);
        this.identity = identity;
    }

    public int getIdentity() {
        return identity;
    }
}
