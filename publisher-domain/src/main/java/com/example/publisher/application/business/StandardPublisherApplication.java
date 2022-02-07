package com.example.publisher.application.business;

import com.example.publisher.domain.Publisher;
import com.example.publisher.domain.PublisherId;
import com.example.publisher.infrastructure.EventPublisher;
import com.example.publisher.repository.PublisherRepository;
import com.example.publisher.application.PublisherApplication;
import com.example.publisher.application.business.event.BookSupplyEvent;
import com.example.publisher.application.business.exception.ExistingPublisherException;
import com.example.publisher.application.business.exception.PublisherNotFoundException;
import com.example.requisition.application.RequisitionApplication;
import com.example.requisition.domain.Requisition;
import com.example.shared.domain.Isbn;

import java.util.List;
import java.util.Optional;

public class StandardPublisherApplication implements PublisherApplication {
    private final EventPublisher eventPublisher;
    private final PublisherRepository publisherRepository;
    private final RequisitionApplication requisitionApplication;

    public StandardPublisherApplication(EventPublisher eventPublisher, PublisherRepository publisherRepository,RequisitionApplication requisitionApplication) {
        this.eventPublisher = eventPublisher;
        this.publisherRepository = publisherRepository;
        this.requisitionApplication=requisitionApplication;
    }

    public Publisher addPublisher(Publisher publisher) {
        PublisherId publisherId = publisher.getPublisherId();
        if (publisherRepository.ExistPublisherByPublisherId(publisherId))
            throw new ExistingPublisherException("Already exist,", publisherId.getPublisherId());
        var addedPublisher = publisherRepository.savePublisher(publisher);
        return addedPublisher;
    }

    public Publisher deletePublisher(PublisherId publisherId) {
            Optional<Publisher> deletedPublisher=publisherRepository.delete(publisherId);
            var publisher= deletedPublisher.orElseThrow(()->new PublisherNotFoundException("Publisher does not exist",publisherId.getPublisherId()));
        return deletedPublisher.get();
    }

    @Override
    public List<Requisition> inspectRequisition(PublisherId publisherId) {
        var requisitions = requisitionApplication.findRequisitionsByPublisherId(publisherId);
        return requisitions;
    }

    @Override
    public boolean supplyBooks(Isbn isbn, PublisherId publisherId, int amount) {
        BookSupplyEvent bookSupplyEvent= new BookSupplyEvent(isbn, publisherId, amount);
        eventPublisher.publishEvent(bookSupplyEvent);
        return true;
    }


}
