package com.example.requisition.infra;

public interface EventPublisher<RequisitionEvent> {
    
    void publishEvent(RequisitionEvent businessEvent);

}
