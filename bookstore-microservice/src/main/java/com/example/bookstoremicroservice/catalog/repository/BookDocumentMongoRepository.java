package com.example.bookstoremicroservice.catalog.repository;

import com.example.bookstoremicroservice.catalog.document.BookDocument;
import com.example.domain.category.CategoryId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookDocumentMongoRepository extends MongoRepository<BookDocument,String> {

   List<BookDocument> findAllByCategoryId(int categoryId);
}
