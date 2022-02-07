package com.example.publisher.application.business.exception;

public class ExistingPublisherException extends RuntimeException {
    private final int publisherId;

    public ExistingPublisherException(String message, int publisherId) {
       super(message);
       this.publisherId = publisherId;
    }
    public int getPublisherId() {
        return publisherId;
    }
}
