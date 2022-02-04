package com.example.bookstoremicroservice.repository;

import com.example.bookstoremicroservice.document.customer.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository  extends MongoRepository<CustomerDocument,String> {
}
