package com.example.bookstoremicroservice.publisher.dto.response;



public class PublisherResponse {

    private  int publisherId;
    private String name;

    public PublisherResponse() {
    }

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

    @Override
    public String toString() {
        return "PublisherResponse{" +
                "publisherId=" + publisherId +
                ", name='" + name + '\'' +
                '}';
    }
}
