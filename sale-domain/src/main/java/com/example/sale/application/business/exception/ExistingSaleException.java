package com.example.sale.application.business.exception;

public class ExistingSaleException extends RuntimeException {

    private final int saleId;

    public ExistingSaleException(String message, int saleId){
        super(message);
        this.saleId = saleId;
    }

    public int getIdentity() {
        return saleId;
    }

}

