package com.example.stock.repository;

import com.example.shared.domain.Isbn;
import com.example.stock.domain.Stock;
import com.example.stock.domain.StockKeepingUnit;

import java.util.Optional;

public interface StockRepository {

    Optional<Stock> updateStock(Stock stock);

    Optional<Stock> findStockBySku(StockKeepingUnit sku);

    Optional<Stock> findStockByBookIsbn(Isbn isbn);

}
