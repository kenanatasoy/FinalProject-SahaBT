package com.example.requisition.application.business.exception;

@SuppressWarnings("serial")
public class RequisitionNotFoundException extends RuntimeException {

    private final Long identity;

    public RequisitionNotFoundException(String message, Long identity){
        super(message);
        this.identity = identity;
    }

    public Long getIdentity() {
        return identity;
    }

}
