package com.example.requisition.application.business.event;

import com.example.shared.domain.Isbn;

import java.util.UUID;

public class StockUnderCriticalLevelEvent  {

    private final String eventId;
    private final Long bookRequisitionAmount;
    private final Isbn isbn;


    public StockUnderCriticalLevelEvent(Long bookRequisitionAmount, Isbn isbn){
        this.eventId = UUID.randomUUID().toString();
        this.bookRequisitionAmount = bookRequisitionAmount;
        this.isbn = isbn;
    }

    public String getEventId() {
        return eventId;
    }

    public Long getRequisitionAmount() {
        return bookRequisitionAmount;
    }

    public Isbn getIsbn() {
        return isbn;
    }

}