package com.example.sale.repository;

import com.example.category.domain.Category;
import com.example.domain.book.Isbn;
import com.example.sale.domain.Sale;
import com.example.sale.domain.SaleId;

import java.util.List;
import java.util.Optional;

public interface SaleRepository {

    Boolean  existBySaleId(SaleId saleId);

     Optional<Sale> findBySaleId(SaleId saleId);
    List<Sale> listSales();

    Optional<Sale> findByBookIsbn(Isbn isbn);
    Optional<Sale> findByCustomerId(Identity customerId);

     Sale saveSale(Sale sale);

}
