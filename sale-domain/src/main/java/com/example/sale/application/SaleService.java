package com.example.sale.application;

import com.example.category.domain.Category;
import com.example.domain.book.Isbn;
import com.example.sale.domain.Sale;
import com.example.sale.domain.SaleId;

import java.util.List;
import java.util.Optional;

public interface SaleService {

    Sale getBySaleId(SaleId saleId);
    Sale getByBookId(Isbn isbn);
    Sale makeSale(Sale sale);
    List<Sale> listSales();
   Sale getByCustomerId(Identity customerId);
    //Todo:Customer

}
