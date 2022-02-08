package com.example.publisher.application.business.exception;

public class PublisherNotFoundException extends RuntimeException {
    private final long publisherId;

    public PublisherNotFoundException(String message, long publisherId) {
        super(message);
        this.publisherId = publisherId;
    }

    public long getPublisherId() {
        return publisherId;
    }
}
