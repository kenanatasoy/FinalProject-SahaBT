package com.example.publisher.service.business.exception;

public class PublisherNotFoundException extends RuntimeException {
    private final int publisherId;

    public PublisherNotFoundException(String message, int publisherId) {
        super(message);
        this.publisherId = publisherId;
    }

    public int getPublisherId() {
        return publisherId;
    }
}
