package com.example.sale.application.business.exception;

public class ExistingNotFoundException extends RuntimeException {

    private final int saleId;

    public ExistingNotFoundException(String message, int saleId){
        super(message);
        this.saleId = saleId;
    }

    public int getIdentity() {
        return saleId;
    }

}

