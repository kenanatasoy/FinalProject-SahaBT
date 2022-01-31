package com.example.sale.application.business.exception;

public class SaleNotFoundException extends RuntimeException {

    private final int saleId;

    public SaleNotFoundException(String message, int saleId){
        super(message);
        this.saleId = saleId;
    }

    public int getIdentity() {
        return saleId;
    }

}
