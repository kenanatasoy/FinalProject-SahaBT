package com.example.bookstoremicroservice.stock.service;

import com.example.bookstoremicroservice.stock.dto.request.StockRequest;
import com.example.bookstoremicroservice.stock.dto.response.FindStockResponse;
import com.example.bookstoremicroservice.stock.dto.response.StockResponse;

public interface StockService {

    StockResponse addStock(StockRequest stockRequest);

    StockResponse updateStockInfo(StockRequest stockRequest);

    FindStockResponse findStockBySku(String stockKeepingUnit);

    FindStockResponse findStockByBookIsbn(String isbn);

}
