package com.example.bookstoremicroservice.stock.service.business;

import com.example.application.business.events.BookAddedEvent;
import com.example.bookstoremicroservice.stock.dto.request.StockRequest;
import com.example.bookstoremicroservice.stock.dto.response.FindStockResponse;
import com.example.bookstoremicroservice.stock.dto.response.StockResponse;
import com.example.bookstoremicroservice.stock.service.StockService;
import com.example.sale.application.business.events.MakeSaleEvent;
import com.example.shared.domain.Isbn;
import com.example.stock.application.StockApplication;
import com.example.stock.domain.Stock;
import com.example.stock.domain.StockKeepingUnit;
import org.modelmapper.ModelMapper;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StandardStockService implements StockService {

    private final StockApplication stockApplication;
    private final ModelMapper modelMapper;

    public StandardStockService(StockApplication stockApplication, ModelMapper modelMapper) {
        this.stockApplication = stockApplication;
        this.modelMapper = modelMapper;
    }


    @Override
    public StockResponse addStock(StockRequest stockRequest) {
        var stock = modelMapper.map(stockRequest, Stock.class);
        var addedStock = stockApplication.addStock(stock);
        return modelMapper.map(addedStock, StockResponse.class);
    }

    @Override
    public StockResponse updateStockInfo(StockRequest stockRequest) {
        var stock = modelMapper.map(stockRequest, Stock.class);
        var updatedStock = stockApplication.updateStockInfo(stock);
        return modelMapper.map(updatedStock, StockResponse.class);
    }

    @Override
    public FindStockResponse findStockBySku(String stockKeepingUnit) {
        var stock = stockApplication.findStockBySku(StockKeepingUnit.of(stockKeepingUnit));
        return modelMapper.map(stock, FindStockResponse.class);
    }

    @Override
    public FindStockResponse findStockByBookIsbn(String isbn) {
        var stock = stockApplication.findStockByBookIsbn(Isbn.valueOf(isbn));
        return modelMapper.map(stock, FindStockResponse.class);
    }


    @EventListener
    public void handleBookAddedEvent(BookAddedEvent event) {
        var isbn = event.getBook().getIsbn().getValue();
        var number = event.getAmount();
        StockRequest stockRequest = new StockRequest();
        stockRequest.setIsbn(isbn);
        stockRequest.setStockKeepingUnit(UUID.randomUUID().toString());
        stockRequest.setNumberOfBooksLeft(number);
        stockRequest.setNumberOfBooksSold(0);
        addStock(stockRequest);
    }

    @EventListener
    private void handleBookSoldEvent(MakeSaleEvent event){
        var isbn = event.getSale().getIsbn().getValue();
        var numberOfSales = event.getAmount();

        Stock stock = modelMapper.map(findStockByBookIsbn(isbn), Stock.class);
        stock.sellFromStock(numberOfSales);
        updateStockInfo(modelMapper.map(stock, StockRequest.class));
    }


}
