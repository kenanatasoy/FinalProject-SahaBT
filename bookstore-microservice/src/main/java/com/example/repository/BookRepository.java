package com.example.repository;

import com.example.document.book.BookDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookDocument,String> {
}
