package com.example.stock.application;

import com.example.shared.domain.Isbn;
import com.example.stock.domain.Stock;
import com.example.stock.domain.StockKeepingUnit;

public interface StockApplication {

    Stock updateStockInfo(Stock stock);

    Stock findStockBySku(StockKeepingUnit sku);

    Stock findStockByBookIsbn(Isbn isbn);

    Boolean maintainThreeMonthStockByIsbn(Isbn isbn);

}
