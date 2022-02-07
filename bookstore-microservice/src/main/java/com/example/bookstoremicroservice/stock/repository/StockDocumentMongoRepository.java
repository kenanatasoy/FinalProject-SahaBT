package com.example.bookstoremicroservice.stock.repository;

import com.example.bookstoremicroservice.stock.document.StockDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockDocumentMongoRepository extends MongoRepository<StockDocument, String> {

}