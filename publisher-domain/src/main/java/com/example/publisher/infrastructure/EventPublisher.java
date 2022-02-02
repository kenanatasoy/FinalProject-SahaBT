package com.example.publisher.infrastructure;


import com.example.publisher.service.business.event.BookSupplyEvent;
import com.example.publisher.service.business.event.PublisherEvent;

public interface EventPublisher {

    void publishEvent(BookSupplyEvent businessEvent);
}
