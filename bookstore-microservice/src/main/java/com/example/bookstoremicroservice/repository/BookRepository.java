package com.example.bookstoremicroservice.repository;

import com.example.bookstoremicroservice.document.book.BookDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookDocument,String> {
}
