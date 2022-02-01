package com.example.stock.repository;

import com.example.stock.domain.Stock;

import java.util.Optional;

public interface StockRepository {

    Optional<Stock> updateStock(Stock stock);

}
