package com.example.bookstoremicroservice.publisher.repository;

import com.example.bookstoremicroservice.publisher.document.PublisherDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublisherDocumentMongoRepository extends MongoRepository<PublisherDocument,Integer> {
}
