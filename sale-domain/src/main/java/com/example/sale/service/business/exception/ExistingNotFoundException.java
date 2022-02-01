package com.example.sale.service.business.exception;

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

