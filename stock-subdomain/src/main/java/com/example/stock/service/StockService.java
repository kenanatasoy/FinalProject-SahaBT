package com.example.stock.service;

import com.example.stock.domain.Isbn;
import com.example.stock.domain.Stock;
import com.example.stock.domain.StockKeepingUnit;

public interface StockService {

    Stock updateStockInfo(Stock stock);

    Stock findStockBySku(StockKeepingUnit sku);

    Stock findStockByBookIsbn(Isbn isbn);

}
