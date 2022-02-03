package com.example.bookstoremicroservice.service.repository;

import com.example.bookstoremicroservice.document.SaleDocument;
import com.example.sale.domain.Sale;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SaleDocumentRepository extends MongoRepository<SaleDocument,Integer> {
    List<Sale> findByBookId(String value);

    List<Sale> findByCustomerId(String value);
}
