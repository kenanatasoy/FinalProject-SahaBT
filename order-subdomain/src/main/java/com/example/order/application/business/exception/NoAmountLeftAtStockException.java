package com.example.order.application.business.exception;

public class NoAmountLeftAtStockException extends RuntimeException {

    private final Long isbn;

    public NoAmountLeftAtStockException(String message, Long identity) {
        super(message);
        this.isbn = identity;
    }

    public Long getIdentity() {
        return isbn;
    }

}