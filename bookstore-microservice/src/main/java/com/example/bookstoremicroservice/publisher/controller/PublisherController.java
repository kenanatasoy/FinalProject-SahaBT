package com.example.bookstoremicroservice.publisher.controller;

import com.example.bookstoremicroservice.publisher.dto.request.PublisherRequest;
import com.example.bookstoremicroservice.publisher.dto.response.DeletePublisherResponse;
import com.example.bookstoremicroservice.publisher.dto.response.PublisherResponse;
import com.example.bookstoremicroservice.publisher.service.PublisherService;
import com.example.publisher.domain.Publisher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
@RequestMapping("publisher")
@CrossOrigin
public class PublisherController {

    private  PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping
    PublisherResponse addPublisher(@RequestBody PublisherRequest publisher){

        return publisherService.addPublisher(publisher);
    }

    @DeleteMapping("{publisherId}")
    public DeletePublisherResponse deletePublisher(@PathVariable int publisherId)
    {
       return publisherService.deletePublisherId(publisherId);
    }





}
