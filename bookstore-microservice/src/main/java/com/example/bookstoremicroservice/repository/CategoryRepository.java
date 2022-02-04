package com.example.bookstoremicroservice.repository;

import com.example.bookstoremicroservice.document.CategoryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<CategoryDocument,Integer> {
}
