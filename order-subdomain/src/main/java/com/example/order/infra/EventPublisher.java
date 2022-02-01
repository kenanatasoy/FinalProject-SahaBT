package com.example.order.infra;


import com.example.order.application.business.event.OrderMadeEvent;

public interface EventPublisher {

    void publishEvent(OrderMadeEvent businessEvent);

}
