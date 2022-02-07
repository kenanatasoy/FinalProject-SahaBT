package com.example.bookstoremicroservice.stock.adapter;

import com.example.bookstoremicroservice.stock.document.StockDocument;
import com.example.bookstoremicroservice.stock.repository.StockDocumentMongoRepository;
import com.example.shared.domain.Isbn;
import com.example.stock.domain.Stock;
import com.example.stock.domain.StockKeepingUnit;
import com.example.stock.repository.StockRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockRepositoryMongoAdapter implements StockRepository {

    private final StockDocumentMongoRepository mongoRepo;
    private final ModelMapper mapper;

    public StockRepositoryMongoAdapter(StockDocumentMongoRepository mongoRepo, ModelMapper mapper) {
        this.mongoRepo = mongoRepo;
        this.mapper = mapper;
    }

    @Override
    public Stock save(Stock stock) {
        var document = mapper.map(stock, StockDocument.class);
        return mapper.map(mongoRepo.save(document), Stock.class);
    }

    @Override
    public boolean existsBySku(StockKeepingUnit sku) {
        return mongoRepo.existsById(sku.getValue());
    }

    @Override
    public Optional<Stock> updateStock(Stock stock) {
        var stockDocument = mapper.map(stock, StockDocument.class);
        return Optional.ofNullable(mapper.map(mongoRepo.save(stockDocument), Stock.class));
    }

    @Override
    public Optional<Stock> findStockBySku(StockKeepingUnit sku) {
        return mongoRepo.findById(sku.getValue())
                .map(doc -> mapper.map(doc, Stock.class));
    }

    @Override
    public Optional<Stock> findStockByBookIsbn(Isbn isbn) {
        return mongoRepo.findById(isbn.getValue())
                .map(doc -> mapper.map(doc, Stock.class));
    }

}