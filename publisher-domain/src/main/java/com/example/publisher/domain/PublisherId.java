package com.example.publisher.domain;

public class PublisherId {
    private final long publisherId;

    private PublisherId(long publisherId) {
        this.publisherId = publisherId;
    }
    public static PublisherId valueOf(long publisherId){
        return new PublisherId(publisherId);
    }

    public long getPublisherId() {
        return publisherId;
    }

    @Override
    public String toString() {
        return "PublisherId{" +
                "publisherId=" + publisherId +
                '}';
    }
}
