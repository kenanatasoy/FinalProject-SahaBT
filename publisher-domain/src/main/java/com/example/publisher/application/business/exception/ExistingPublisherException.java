package com.example.publisher.application.business.exception;

public class ExistingPublisherException extends RuntimeException {
    private final long publisherId;

    public ExistingPublisherException(String message, long publisherId) {
       super(message);
       this.publisherId = publisherId;
    }
    public long getPublisherId() {
        return publisherId;
    }
}
