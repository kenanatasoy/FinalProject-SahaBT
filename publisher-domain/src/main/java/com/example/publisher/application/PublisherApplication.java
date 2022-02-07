package com.example.publisher.application;

import com.example.publisher.domain.Publisher;
import com.example.publisher.domain.PublisherId;
import com.example.requisition.domain.Requisition;
import com.example.shared.domain.Isbn;

import java.util.List;

public interface PublisherApplication {
    Publisher addPublisher(Publisher publisher);
    Publisher deletePublisher(PublisherId publisherId);
    void inspectRequisitions();
    void supplyBook(Isbn isbn, int numberOfBooksToSupply);


}
