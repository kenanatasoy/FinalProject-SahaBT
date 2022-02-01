package com.example.stock.service.business.exception;

@SuppressWarnings("serial")
public class StockNotFoundException extends RuntimeException {

    private final String stockKeepingUnit;

    public StockNotFoundException(String message, String stockKeepingUnit){
        super(message);
        this.stockKeepingUnit = stockKeepingUnit;
    }

    public String getIdentity() {
        return stockKeepingUnit;
    }

}