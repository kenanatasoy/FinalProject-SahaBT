package com.example.requisition.infra;

public interface EventPublisher<Event> {
    void publishEvent(Event event);
}