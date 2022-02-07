package com.example.bookstoremicroservice.publisher.service;

import com.example.bookstoremicroservice.publisher.dto.request.PublisherRequest;
import com.example.bookstoremicroservice.publisher.dto.response.DeletePublisherResponse;
import com.example.bookstoremicroservice.publisher.dto.response.PublisherResponse;

public interface PublisherService {
    PublisherResponse addPublisher(PublisherRequest publisher);

    DeletePublisherResponse deletePublisherId(int publisherId);
}
