package com.example.bookstoremicroservice.publisher.dto.request;


import org.apache.kafka.common.protocol.types.Field;

public class PublisherRequest {

    private  int publisherId;
    private String firstName;
    private String lastName;
    private String logo;

    public PublisherRequest() {
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "PublisherRequest{" +
                "publisherId=" + publisherId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
