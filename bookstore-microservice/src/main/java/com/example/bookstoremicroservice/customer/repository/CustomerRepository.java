package com.example.bookstoremicroservice.customer.repository;

import com.example.bookstoremicroservice.customer.document.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository  extends MongoRepository<CustomerDocument,String> {
}
