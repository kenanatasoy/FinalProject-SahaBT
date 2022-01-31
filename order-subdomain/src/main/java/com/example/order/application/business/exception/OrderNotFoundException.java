package com.example.order.application.business.exception;

@SuppressWarnings("serial")
public class OrderNotFoundException extends RuntimeException {

    private final String identity;

    public OrderNotFoundException(String message, String identity) {
        super(message);
        this.identity = identity;
    }

    public String getIdentity() {
        return identity;
    }

}
