package com.example.sale.application.business.events;

import com.example.sale.domain.Sale;

public class MakeSaleEvent extends SaleEvent{

    private final Sale sale;
    private final int amount;

    public MakeSaleEvent(Sale sale, int amount) {
        this.sale = sale;
        this.amount = amount;
    }

    public Sale getSale(){
        return sale;
    }

    public int getAmount() {
        return amount;
    }
}
