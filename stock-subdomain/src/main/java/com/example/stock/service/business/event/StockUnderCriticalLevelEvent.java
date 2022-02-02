package com.example.stock.service.business.event;

import com.example.shared.domain.Isbn;

import java.util.UUID;

public class StockUnderCriticalLevelEvent  {

    private final String eventId;
    private final Integer requisitionAmount;
    private final Isbn isbn;


    public StockUnderCriticalLevelEvent(Integer requisitionAmount, Isbn isbn){
        this.eventId = UUID.randomUUID().toString();
        this.requisitionAmount = requisitionAmount;
        this.isbn = isbn;
    }

    public String getEventId() {
        return eventId;
    }

    public Integer getRequisitionAmount() {
        return requisitionAmount;
    }

    public Isbn getIsbn() {
        return isbn;
    }
}