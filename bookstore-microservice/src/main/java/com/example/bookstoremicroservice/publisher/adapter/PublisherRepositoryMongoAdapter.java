package com.example.bookstoremicroservice.publisher.adapter;

import com.example.bookstoremicroservice.publisher.document.PublisherDocument;
import com.example.bookstoremicroservice.publisher.repository.PublisherDocumentMongoRepository;
import com.example.publisher.domain.Publisher;
import com.example.publisher.domain.PublisherId;
import com.example.publisher.repository.PublisherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PublisherRepositoryMongoAdapter implements PublisherRepository {

    private PublisherDocumentMongoRepository publisherDocumentMongoRepository;
    private ModelMapper modelMapper;

    public PublisherRepositoryMongoAdapter(PublisherDocumentMongoRepository publisherDocumentMongoRepository, ModelMapper modelMapper) {
        this.publisherDocumentMongoRepository = publisherDocumentMongoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean ExistPublisherByPublisherId(PublisherId publisherId) {
        return publisherDocumentMongoRepository.existsById(publisherId.getPublisherId());
    }

    @Override
    public Publisher savePublisher(Publisher publisher) {
        var document = modelMapper.map(publisher, PublisherDocument.class);

        return modelMapper.map(publisherDocumentMongoRepository.save(document),Publisher.class);
    }

    @Override
    public Optional<Publisher> delete(PublisherId publisherId) {
       var document = publisherDocumentMongoRepository.findById(publisherId.getPublisherId());
       document.ifPresent(publisherDocumentMongoRepository::delete);
       return document.map(doc-> modelMapper.map(doc,Publisher.class));

    }
}
