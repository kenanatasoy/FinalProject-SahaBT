package com.example.order.application.business.exception;

@SuppressWarnings("serial")
public class ExistingOrderException extends RuntimeException {

    private final Long identity;

    public ExistingOrderException(String message, Long identity) {
        super(message);
        this.identity = identity;
    }

    public Long getIdentity() {
        return identity;
    }

}
