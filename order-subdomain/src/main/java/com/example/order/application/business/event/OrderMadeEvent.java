package com.example.order.application.business.event;

import com.example.order.domain.Order;

import java.util.UUID;

public class OrderMadeEvent {

    private final String eventId;
    private final Order order;

    public OrderMadeEvent(Order order){
        this.eventId = UUID.randomUUID().toString();
        this.order = order;
    }

    public String getEventId() {
        return eventId;
    }

    public Order getOrder(){
        return order;
    }

}
