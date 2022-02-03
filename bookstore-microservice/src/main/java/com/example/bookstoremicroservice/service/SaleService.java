package com.example.bookstoremicroservice.service;

import com.example.bookstoremicroservice.dto.response.SaleResponse;

import java.util.List;

public interface SaleService {


    List<SaleResponse> findSalesByPages(int page, int size);

    List<SaleResponse> getSalesByBookId(String bookId);

    SaleResponse findBySaleId(int saleId);

    List<SaleResponse> getSalesByCustomerId(String customerId);
}
