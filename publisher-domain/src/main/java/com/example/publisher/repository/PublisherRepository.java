package com.example.publisher.repository;

import com.example.publisher.domain.Publisher;
import com.example.publisher.domain.PublisherId;
import com.example.shared.domain.Isbn;

import java.util.Optional;

public interface PublisherRepository {
    boolean ExistPublisherByPublisherId(PublisherId publisherId);
    Publisher savePublisher(Publisher publisher);
    Optional<Publisher> delete(PublisherId publisherId);
}
