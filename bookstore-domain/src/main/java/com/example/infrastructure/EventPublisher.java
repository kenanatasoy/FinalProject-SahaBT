package com.example.infrastructure;

public interface EventPublisher {

    void publishEvent(BookEvent businessEvent);
}
