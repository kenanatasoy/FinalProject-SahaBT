package com.example.stock.service.business;

import com.example.stock.domain.Isbn;
import com.example.stock.domain.Stock;
import com.example.stock.domain.StockKeepingUnit;
import com.example.stock.repository.StockRepository;
import com.example.stock.service.StockService;
import com.example.stock.service.business.exception.StockNotFoundException;

public class StandardStockService implements StockService {

    private final StockRepository stockRepository;

    public StandardStockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock updateStockInfo(Stock stock) {
        return stockRepository.updateStock(stock)
                .orElseThrow(() -> new StockNotFoundException("Stock has not been found", stock.getSku().getValue()));
    }

    @Override
    public Stock findStockBySku(StockKeepingUnit sku) {
        return stockRepository.findStockBySku(sku)
                .orElseThrow(() -> new StockNotFoundException("Stock has not been found", sku.getValue()));
    }

    @Override
    public Stock findStockByBookIsbn(Isbn isbn) {
        return stockRepository.findStockByBookIsbn(isbn)
                .orElseThrow(() -> new StockNotFoundException("Stock has not been found", isbn.getValue()));
    }


}

