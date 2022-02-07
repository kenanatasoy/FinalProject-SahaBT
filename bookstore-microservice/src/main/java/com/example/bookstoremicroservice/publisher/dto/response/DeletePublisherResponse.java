package com.example.bookstoremicroservice.publisher.dto.response;

public class DeletePublisherResponse {
    private  int publisherId;
    private String name;

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeletePublisherResponse() {

    }

    @Override
    public String toString() {
        return "DeletePublisherResponse{" +
                "publisherId=" + publisherId +
                ", name='" + name + '\'' +
                '}';
    }
}
