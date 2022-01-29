package com.example.domain;

public class PublisherId {
    private final int publisherId;

    private PublisherId(int publisherId) {
        this.publisherId = publisherId;
    }
    public static PublisherId valueOf(int publisherId){
        return new PublisherId(publisherId);
    }

    public int getPublisherId() {
        return publisherId;
    }

    @Override
    public String toString() {
        return "PublisherId{" +
                "publisherId=" + publisherId +
                '}';
    }
}
