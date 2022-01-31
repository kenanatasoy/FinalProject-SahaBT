package com.example.requisition.application.business.event;

import com.example.requisition.domain.Requisition;

import java.util.UUID;

public class RequisitionEvent {

    private final String eventId;
    private final Requisition requisition;

    public RequisitionEvent(Requisition requisition){
        this.eventId = UUID.randomUUID().toString();
        this.requisition = requisition;
    }

    public String getEventId() {
        return eventId;
    }

    public Requisition getOrder(){
        return requisition;
    }

}

