package com.example.bookstoremicroservice.service.repository;

import com.example.bookstoremicroservice.document.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository  extends MongoRepository<CustomerDocument,String> {
}
