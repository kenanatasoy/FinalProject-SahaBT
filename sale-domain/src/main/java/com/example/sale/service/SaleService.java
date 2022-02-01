package com.example.sale.service;

import com.example.domain.book.Isbn;
import com.example.sale.domain.Sale;
import com.example.sale.domain.SaleId;

import java.util.List;

public interface SaleService {

    Sale getBySaleId(SaleId saleId);

    List<Sale> getByBookId(Isbn isbn);

    Sale makeSale(Sale sale);

    List<Sale> listSales();

   // List<Sale> getByCustomerId(Identity customerId);
    //Todo:Customer

}