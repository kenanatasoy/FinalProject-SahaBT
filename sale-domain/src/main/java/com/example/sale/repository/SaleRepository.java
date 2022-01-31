package com.example.sale.repository;

import com.example.sale.book.Isbn;
import com.example.sale.domain.Sale;
import com.example.sale.domain.SaleId;

import java.util.Optional;

public interface SaleRepository {

    Boolean  existBySaleId(SaleId saleId);

     Optional<Sale> findBySaleId(SaleId saleId);

    Optional<Sale> findByBookIsbn(Isbn isbn);

     Sale saveSale(Sale sale);

}
