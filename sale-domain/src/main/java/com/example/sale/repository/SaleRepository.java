package com.example.sale.repository;


import com.example.sale.domain.Sale;
import com.example.sale.domain.SaleId;
import com.example.shared.domain.Isbn;

import java.util.List;
import java.util.Optional;

public interface SaleRepository {

    Boolean existBySaleId(SaleId saleId);

    Optional<Sale> findBySaleId(SaleId saleId);

    List<Sale> listSales();

    List<Sale> findByBookIsbn(Isbn isbn);

   // List<Sale> findByCustomerId(Identity customerId);

    Sale saveSale(Sale sale);

}
