package com.example.sale.application;


import com.example.sale.domain.Sale;
import com.example.sale.domain.SaleId;
import com.example.shared.domain.Isbn;

import java.util.List;

public interface SaleService {

    Sale getBySaleId(SaleId saleId);

    List<Sale> getByBookId(Isbn isbn);

    Sale makeSale(Sale sale,int amount);

    List<Sale> listSales();
    List<Sale> getLastThreeMonthSale();


    List<Sale> getByCustomerId(Identity customerId);
    //Todo:Customer

}
