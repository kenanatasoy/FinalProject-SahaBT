package com.example.sale.application;

import com.example.sale.book.Isbn;
import com.example.sale.domain.Sale;
import com.example.sale.domain.SaleId;

public interface SaleService {

    Sale getBySaleId(SaleId saleId);
    Sale getByBookId(Isbn isbn);
    Sale makeSale(Sale sale);

    //Todo:Customer

}
