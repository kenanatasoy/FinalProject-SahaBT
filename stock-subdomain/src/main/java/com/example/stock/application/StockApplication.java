package com.example.stock.application;

import com.example.shared.domain.Isbn;
import com.example.stock.domain.Stock;
import com.example.stock.domain.StockKeepingUnit;

import java.util.Optional;

public interface StockApplication {

    Stock updateStockInfo(Stock stock);

    Stock findStockBySku(StockKeepingUnit sku);

    Stock findStockByBookIsbn(Isbn isbn);

    Stock addStock(Stock stock);

}
