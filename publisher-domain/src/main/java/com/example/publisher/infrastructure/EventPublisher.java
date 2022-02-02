package com.example.publisher.infrastructure;


public interface EventPublisher {

    void publishEvent(PublisherEvent businessEvent);
}
