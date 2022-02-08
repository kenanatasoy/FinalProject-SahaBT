package com.example.bookstoremicroservice.requisition.repository;

import com.example.bookstoremicroservice.requisition.document.RequisitionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RequisitionDocumentMongoRepository extends MongoRepository<RequisitionDocument, Long> {

    Optional<RequisitionDocument> findByIsbn(String isbn);
    List<RequisitionDocument> findAllByPublisherId(Long publisherId);

}
