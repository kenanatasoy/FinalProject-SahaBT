package com.example.sale.service.business.events;

import com.example.sale.domain.Sale;

public class MakeSaleEvent extends SaleEvent{

    private final Sale sale;

    public MakeSaleEvent(Sale sale) {
        this.sale = sale;
    }

    public Sale getSale(){
        return sale;
    }
}
