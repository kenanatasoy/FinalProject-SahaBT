package com.example.bookstoremicroservice.sale.service;

import com.example.bookstoremicroservice.sale.dto.request.MakeSaleRequest;
import com.example.bookstoremicroservice.sale.dto.response.MakeSaleResponse;
import com.example.bookstoremicroservice.sale.dto.response.SaleResponse;

import java.util.List;

public interface SaleService {


    List<SaleResponse> findSalesByPages(int page, int size);

    List<SaleResponse> getSalesByBookId(String bookId);

    SaleResponse findBySaleId(int saleId);

    List<SaleResponse> getSalesByCustomerId(String customerId);


    MakeSaleResponse makeSale(MakeSaleRequest sale, int amount);

     List<SaleResponse> getLastThreeMonthSalesByIsbn(String isbn);

    long getNumberOfLastThreeMonthSalesByIsbn(String isbn);
}
