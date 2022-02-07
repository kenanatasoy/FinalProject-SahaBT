package com.example.bookstoremicroservice.requisition.adapter;

import com.example.bookstoremicroservice.requisition.repository.RequisitionDocumentMongoRepository;
import com.example.bookstoremicroservice.stock.document.StockDocument;
import com.example.bookstoremicroservice.stock.repository.StockDocumentMongoRepository;
import com.example.publisher.domain.PublisherId;
import com.example.requisition.domain.Requisition;
import com.example.requisition.domain.RequisitionId;
import com.example.requisition.repository.RequisitionRepository;
import com.example.shared.domain.Isbn;
import com.example.stock.domain.Stock;
import com.example.stock.domain.StockKeepingUnit;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RequisitionRepositoryMongoAdapter implements RequisitionRepository {

    private final RequisitionDocumentMongoRepository mongoRepo;
    private final ModelMapper mapper;

    public RequisitionRepositoryMongoAdapter(RequisitionDocumentMongoRepository mongoRepo, ModelMapper mapper) {
        this.mongoRepo = mongoRepo;
        this.mapper = mapper;
    }

    //TODO
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
