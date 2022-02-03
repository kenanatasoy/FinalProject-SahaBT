package com.example.bookstoremicroservice.service.repository;

import com.example.bookstoremicroservice.document.BookDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookDocument,String> {
}
