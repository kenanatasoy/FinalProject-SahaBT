package com.example.requisition.application.business.exception;

@SuppressWarnings("serial")
public class ExistingRequisitionException extends RuntimeException{

    private final Long identity;

    public ExistingRequisitionException(String message, Long identity) {
        super(message);
        this.identity = identity;
    }

    public Long getIdentity() {
        return identity;
    }
}
