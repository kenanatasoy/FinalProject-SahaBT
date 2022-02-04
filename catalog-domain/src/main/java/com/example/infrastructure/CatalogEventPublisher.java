package com.example.infrastructure;


import com.example.application.business.events.BookEvent;


public interface CatalogEventPublisher<Event extends BookEvent> {

    void publishEvent(Event businessEvent);

}
