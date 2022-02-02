package com.example.sale.application.business.events;
import java.util.UUID;
public class SaleEvent {
    private final String eventId;

    public SaleEvent() {
        this.eventId = UUID.randomUUID().toString();
    }

    public String getEventId() {
        return eventId;
    }
}
