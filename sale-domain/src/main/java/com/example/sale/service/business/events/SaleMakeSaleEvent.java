package com.example.sale.service.business.events;

import com.example.sale.domain.Sale;

public class SaleMakeSaleEvent extends SaleEvent{

    private final Sale sale;

    public SaleMakeSaleEvent(Sale sale) {
        this.sale = sale;
    }

    public Sale getSale(){



        return sale;
    }
}
