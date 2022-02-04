package com.example.bookstoremicroservice.sale.repository;

import com.example.bookstoremicroservice.sale.document.SaleDocument;
import com.example.sale.domain.Sale;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SaleDocumentMongoRepository extends MongoRepository<SaleDocument,Integer> {
    List<Sale> findByBookId(String value);
    //TODO
    List<Sale> findByCustomerId(String value);
}
