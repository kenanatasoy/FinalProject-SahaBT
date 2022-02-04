package com.example.sale.application;


import com.example.sale.domain.Sale;
import com.example.sale.domain.SaleId;
import com.example.shared.domain.CustomerId;
import com.example.shared.domain.Isbn;

import java.util.List;

public interface SaleApplication {

    Sale getBySaleId(SaleId saleId); // yapıldı

    List<Sale> getSalesByBookId(Isbn isbn); //yapıldı

    List<Sale> getByCustomerId(CustomerId customerId);// yapıldı

    List<Sale> findSalesByPages(int page , int size); //yapıldı

    Sale makeSale(Sale sale,int amount); // yapıldı

    List<Sale> getLastThreeMonthSalesByIsbn(Isbn isbn);

    long getNumberOfLastThreeMonthSalesByIsbn(Isbn isbn);

    List<Sale> listSales();



   // List<Sale> getLastThreeMonthSales();

   // long getNumberOfLastThreeMonthSales();






}
