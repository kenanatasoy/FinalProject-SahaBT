package com.example.bookstoremicroservice.catalog.repository;

import com.example.bookstoremicroservice.catalog.document.BookDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookDocument,String> {
}
