package com.example.order.infra;


public interface EventPublisher<OrderMadeEvent> {

    void publishEvent(OrderMadeEvent businessEvent);

}
