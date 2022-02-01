package com.example.infrastructure;

import com.example.application.business.events.BookAddedEvent;

public interface EventPublisher {

    void publishEvent(BookAddedEvent businessEvent);
}
