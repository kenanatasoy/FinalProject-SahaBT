package com.example.sale.infrastructure;

import com.example.sale.service.business.events.SaleEvent;

public interface EventPublisher {
    void publishEvent(SaleEvent businessEvent);
}
