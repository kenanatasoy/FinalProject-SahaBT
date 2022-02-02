package com.example.publisher.domain;

public class Publisher {

    private final PublisherId publisherId;
    private PublisherName name;
    private PublisherLogo logo;

    public static class Builder{
        private PublisherId publisherId;
        private PublisherName name;
        private PublisherLogo logo;

        public Builder publisherId(int publisherId) {
            this.publisherId = PublisherId.valueOf(publisherId);
            return this;
        }

        public Builder name(String first, String last) {
            this.name = PublisherName.of(first,last);
            return this;
        }

        public Builder logo(byte[] values) {
            this.logo = PublisherLogo.valueOf(values);
            return this;
        }
        public Builder logo(String base64Values) {
            this.logo = PublisherLogo.valueOf(base64Values);
            return this;
        }

        public Publisher build(){
            var publisher = new Publisher(this.publisherId);
            publisher.setName(name);
            publisher.setLogo(logo);
            return publisher;
        }
    }

    private Publisher(PublisherId publisherId) {
        this.publisherId = publisherId;
    }

    public PublisherId getPublisherId() {
        return publisherId;
    }

    public PublisherName getName() {
        return name;
    }

    public void setName(PublisherName name) {
        this.name = name;
    }

    public PublisherLogo getLogo() {
        return logo;
    }

    public void setLogo(PublisherLogo logo) {
        this.logo = logo;
    }
}
