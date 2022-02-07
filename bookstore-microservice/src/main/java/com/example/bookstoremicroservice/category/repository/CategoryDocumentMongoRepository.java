package com.example.bookstoremicroservice.category.repository;

import com.example.bookstoremicroservice.category.document.CategoryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryDocumentMongoRepository extends MongoRepository<CategoryDocument,Integer> {
}
