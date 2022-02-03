package com.example.bookstoremicroservice.service.repository;

import com.example.bookstoremicroservice.document.SaleDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SaleDocumentRepository extends MongoRepository<SaleDocument,Integer> {
}
