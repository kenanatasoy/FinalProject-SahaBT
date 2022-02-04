package com.example.sale.infrastructure;

import com.example.sale.application.business.events.SaleEvent;

public interface SaleEventPublisher<Event extends SaleEvent> {
    void publishEvent(Event businessEvent);
}
