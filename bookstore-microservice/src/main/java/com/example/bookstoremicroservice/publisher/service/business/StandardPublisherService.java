package com.example.bookstoremicroservice.publisher.service.business;

import com.example.bookstoremicroservice.publisher.dto.request.PublisherRequest;
import com.example.bookstoremicroservice.publisher.dto.response.DeletePublisherResponse;
import com.example.bookstoremicroservice.publisher.dto.response.PublisherResponse;
import com.example.bookstoremicroservice.publisher.service.PublisherService;
import com.example.publisher.application.PublisherApplication;
import com.example.publisher.domain.Publisher;
import com.example.publisher.domain.PublisherId;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StandardPublisherService implements PublisherService {

    private PublisherApplication publisherApplication;
    private ModelMapper modelMapper;


    public StandardPublisherService( PublisherApplication publisherApplication,ModelMapper modelMapper) {
        this.publisherApplication = publisherApplication;
        this.modelMapper = modelMapper;

    }

    @Override
    public PublisherResponse addPublisher(PublisherRequest request) {
        var publisher = modelMapper.map(request, Publisher.class);
        var addedPublisher=publisherApplication.addPublisher(publisher);
        return modelMapper.map(addedPublisher,PublisherResponse.class);

    }

    @Override
    public DeletePublisherResponse deletePublisherId(int publisherId) {

        var publisher = publisherApplication.deletePublisher(PublisherId.valueOf(publisherId));
        return modelMapper.map(publisher,DeletePublisherResponse.class);

    }
}
