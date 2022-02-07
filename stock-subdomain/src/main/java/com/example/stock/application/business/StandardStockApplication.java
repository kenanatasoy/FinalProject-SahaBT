package com.example.stock.application.business;

import com.example.shared.domain.Isbn;
import com.example.stock.application.business.exception.ExistingStockException;
import com.example.stock.domain.Stock;
import com.example.stock.domain.StockKeepingUnit;
import com.example.stock.repository.StockRepository;
import com.example.stock.application.StockApplication;
import com.example.stock.application.business.exception.StockNotFoundException;

public class StandardStockApplication implements StockApplication {

    private final StockRepository stockRepository;

    public StandardStockApplication(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock addStock(Stock stock) {
        var sku = stock.getSku();
        if (stockRepository.existsBySku(stock.getSku()))
            throw new ExistingStockException("Stock already exist", sku.getValue());
        return stockRepository.save(stock);
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

