package com.example.order.application.business.exception;

@SuppressWarnings("serial")
public class NoOrdersFoundException extends RuntimeException {

    public NoOrdersFoundException(String message) {
        super(message);
    }
}