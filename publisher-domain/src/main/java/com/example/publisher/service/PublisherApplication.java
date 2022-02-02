package com.example.publisher.service;

import com.example.publisher.domain.Publisher;
import com.example.publisher.domain.PublisherId;
import com.example.requisition.application.business.domain.Requisition;
import com.example.shared.domain.Isbn;

import java.util.List;

public interface PublisherApplication {
    Publisher addPublisher(Publisher publisher);
    Publisher deletePublisher(PublisherId publisherId);
    List<Requisition> inspectRequisition(PublisherId publisherId);
    boolean supplyBooks(Isbn isbn, PublisherId publisherId, int amount);



}
