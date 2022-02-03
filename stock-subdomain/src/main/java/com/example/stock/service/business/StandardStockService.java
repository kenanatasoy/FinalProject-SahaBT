package com.example.stock.service.business;

import com.example.sale.application.SaleApplication;
import com.example.shared.domain.Isbn;
import com.example.stock.domain.Stock;
import com.example.stock.domain.StockKeepingUnit;
import com.example.stock.repository.StockRepository;
import com.example.stock.service.StockService;
import com.example.stock.service.business.exception.StockNotFoundException;

public class StandardStockService implements StockService {

    private final StockRepository stockRepository;
    private final SaleApplication saleService;

    public StandardStockService(StockRepository stockRepository, SaleApplication saleService) {
        this.stockRepository = stockRepository;
        this.saleService = saleService;
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

    @Override
    public Boolean maintainThreeMonthStockByIsbn(Isbn isbn) {

        // TODO what to do here?

        return true;
    }


}

