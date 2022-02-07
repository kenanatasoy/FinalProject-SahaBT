package com.example.stock.application.business.exception;

@SuppressWarnings("serial")
public class ExistingStockException extends RuntimeException{

    private final String identity;

    public ExistingStockException(String message, String identity) {
        super(message);
        this.identity = identity;
    }

    public String getIdentity() {
        return identity;
    }
}