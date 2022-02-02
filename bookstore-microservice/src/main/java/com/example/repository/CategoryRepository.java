package com.example.repository;

import com.example.document.CategoryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<CategoryDocument,Integer> {
}
