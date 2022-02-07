package com.example.bookstoremicroservice.publisher.modelMapperConverters;

import com.example.bookstoremicroservice.publisher.dto.request.PublisherRequest;
import com.example.bookstoremicroservice.publisher.dto.response.PublisherResponse;
import com.example.publisher.domain.Publisher;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;

@Component
public class PublisherConverters {

    public static final Converter<Publisher, PublisherResponse>
            PUBLISHER_TO_ADD_PUBLISHER_RESPONSE_CONVERTER =
            (context) -> {
                var publisher = context.getSource();
                var fullname = publisher.getName();
                var response = new PublisherResponse();
                response.setPublisherId(publisher.getPublisherId().getPublisherId());
                response.setName(String.format("%s %s",
                        fullname.getFirst(), fullname.getLast()));
                ;
                return response;
            };

    public static final Converter<PublisherRequest, Publisher>
            ADD_PUBLISHER_REQUEST_TO_PUBLISH_CONVERTER =
            (context) -> {
                var request = context.getSource();
                return new Publisher.Builder()
                        .publisherId(request.getPublisherId())
                        .logo(request.getLogo())
                        .name(request.getFirstName(), request.getLastName())
                        .build();
            };


}
