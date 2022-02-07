package com.example.publisher.infrastructure;


import com.example.publisher.application.business.event.BookSupplyEvent;

public interface EventPublisher {

    void publishEvent(BookSupplyEvent businessEvent);
}
