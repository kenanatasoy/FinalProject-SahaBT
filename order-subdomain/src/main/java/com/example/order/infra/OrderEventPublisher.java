package com.example.order.infra;


import com.example.order.application.business.event.OrderMadeEvent;

public interface OrderEventPublisher {

    void publishEvent(OrderMadeEvent businessEvent);

}
