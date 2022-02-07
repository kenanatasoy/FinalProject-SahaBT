package com.example.requisition.application.business.exception;

@SuppressWarnings("serial")
public class RequisitionNotFoundException extends RuntimeException {

    private Long identity;
    private String isbn;

    public RequisitionNotFoundException(String message, Long identity){
        super(message);
        this.identity = identity;
    }

    public RequisitionNotFoundException(String message, String isbn){
        super(message);
        this.isbn = isbn;
    }

    public Long getIdentity() {
        return identity;
    }

}
