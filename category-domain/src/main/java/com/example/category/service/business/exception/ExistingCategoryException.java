package com.example.category.service.business.exception;
@SuppressWarnings("serial")
public class ExistingCategoryException  extends RuntimeException {

    private final int identity;

    public ExistingCategoryException(String message, int identity) {
        super(message);
        this.identity = identity;
    }

    public int getIdentity() {
        return identity;
    }

}
