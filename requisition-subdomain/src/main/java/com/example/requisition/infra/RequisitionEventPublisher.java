package com.example.requisition.infra;

public interface RequisitionEventPublisher<Event> {
    void publishEvent(Event event);
}