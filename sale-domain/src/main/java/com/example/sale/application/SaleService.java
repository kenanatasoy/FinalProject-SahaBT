package com.example.sale.application;


import com.example.sale.domain.Sale;
import com.example.sale.domain.SaleId;
import com.example.shared.domain.CustomerId;
import com.example.shared.domain.Isbn;

import java.util.List;

public interface SaleService {

    Sale getBySaleId(SaleId saleId);

    List<Sale> getByBookId(Isbn isbn);

    Sale makeSale(Sale sale,int amount);

    List<Sale> listSales();

    List<Sale> getLastThreeMonthSales();

    long getNumberOfLastThreeMonthSales();

    List<Sale> getLastThreeMonthSalesByIsbn(Isbn isbn);

    long getNumberOfLastThreeMonthSalesByIsbn(Isbn isbn);


    List<Sale> getByCustomerId(CustomerId customerId);
    //Todo:Customer

}
