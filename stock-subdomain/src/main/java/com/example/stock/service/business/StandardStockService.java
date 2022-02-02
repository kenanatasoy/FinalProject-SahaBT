package com.example.stock.service.business;

import com.example.sale.application.SaleService;
import com.example.shared.domain.Isbn;
import com.example.stock.domain.Stock;
import com.example.stock.domain.StockKeepingUnit;
import com.example.stock.infra.EventPublisher;
import com.example.stock.repository.StockRepository;
import com.example.stock.service.StockService;
import com.example.stock.service.business.event.StockUnderCriticalLevelEvent;
import com.example.stock.service.business.exception.StockNotFoundException;

public class StandardStockService implements StockService {

    private final StockRepository stockRepository;
    private final SaleService saleService;
    private final EventPublisher<StockUnderCriticalLevelEvent> eventPublisher;

    public StandardStockService(StockRepository stockRepository, SaleService saleService, EventPublisher<StockUnderCriticalLevelEvent> eventPublisher) {
        this.stockRepository = stockRepository;
        this.saleService = saleService;
        this.eventPublisher = eventPublisher;
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

        Stock stock = findStockByBookIsbn(isbn);
        Integer lastThreeMonthStockInfo = saleService.getNumberOfLastThreeMonthSalesByIsbn(isbn);

        if(stock.getNumberOfBooksLeft().getValue() < lastThreeMonthStockInfo){
            var requisitionAmount = lastThreeMonthStockInfo - stock.getNumberOfBooksLeft().getValue();
            StockUnderCriticalLevelEvent businessEvent =
                    new StockUnderCriticalLevelEvent(lastThreeMonthStockInfo, isbn);
            eventPublisher.publishEvent(businessEvent);
            return false;
        }

        return true;
    }


}

