package com.example.bookstoremicroservice.publisher.document;

import com.example.publisher.domain.PublisherId;
import com.example.publisher.domain.PublisherLogo;
import com.example.publisher.domain.PublisherName;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "publisher")
public class PublisherDocument {

    @Id
    private  int publisherId;
    private String name;
    private String logo;

    public PublisherDocument() {
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublisherDocument that = (PublisherDocument) o;
        return publisherId == that.publisherId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherId);
    }

    @Override
    public String toString() {
        return "PublisherDocument{" +
                "publisherId=" + publisherId +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
