package com.example.bookstoremicroservice.requisition.repository;

import com.example.bookstoremicroservice.requisition.document.RequisitionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RequisitionDocumentMongoRepository extends MongoRepository<RequisitionDocument, Long> {

}
