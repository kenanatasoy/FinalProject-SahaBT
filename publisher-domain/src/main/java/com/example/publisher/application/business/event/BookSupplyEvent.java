package com.example.publisher.application.business.event;

import com.example.publisher.domain.PublisherId;
import com.example.shared.domain.Isbn;

public class BookSupplyEvent extends PublisherEvent {
    private final Isbn isbn;
    private final int amount;
    private final PublisherId publisherId;

    public BookSupplyEvent(Isbn isbn, PublisherId publisherId,int amount) {
        this.isbn = isbn;
        this.amount = amount;
        this.publisherId = publisherId;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    public int getAmount() {
        return amount;
    }

    public PublisherId getPublisherId() {
        return publisherId;
    }
}