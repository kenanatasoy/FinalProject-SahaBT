package com.example.infrastructure;


import com.example.application.business.events.BookEvent;

public interface EventPublisher {

    void publishEvent(BookEvent businessEvent);

}
