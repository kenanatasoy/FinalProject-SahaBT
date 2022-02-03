package com.example.customer.infra;

public interface EventPublisher<CustomerOperationEvent> {

    void publishEvent(CustomerOperationEvent customerOperationEvent);
}
