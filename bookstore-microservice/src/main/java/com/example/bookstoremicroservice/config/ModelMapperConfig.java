package com.example.bookstoremicroservice.config;

import com.example.bookstoremicroservice.publisher.dto.request.PublisherRequest;
import com.example.bookstoremicroservice.publisher.dto.response.PublisherResponse;
import com.example.bookstoremicroservice.sale.document.SaleDocument;
import com.example.bookstoremicroservice.sale.dto.request.MakeSaleRequest;
import com.example.bookstoremicroservice.sale.dto.response.MakeSaleResponse;
import com.example.bookstoremicroservice.sale.dto.response.SaleResponse;
import com.example.publisher.domain.Publisher;
import com.example.publisher.domain.PublisherName;
import com.example.sale.domain.Sale;
import com.example.sale.domain.SaleId;
import com.example.shared.domain.CustomerId;
import com.example.shared.domain.Isbn;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    private static final Converter<Sale, SaleResponse>
            SALE_TO_GET_SALE_RESPONSE_CONVERTER =
            (context) -> {
                var sale = context.getSource();
                var saleId = sale.getSaleId();
                var response = new SaleResponse();
                response.setCustomerId(sale.getCustomerId().getValue());
                response.setBookId(sale.getIsbn().getValue());
                response.setSaleDateTime(sale.getTimestamp());

                System.err.println("SALE_TO_GET_SALE_RESPONSE_CONVERTER: "+response);
                return response;
            };

    private static final Converter<SaleDocument, Sale>
            SALE_DOCUMENT_TO_GET_SALE_CONVERTER =
            (context) -> {
                var sale = context.getSource();
                var response = new Sale.Builder();
                response.saleId(sale.getSaleId());
                response.isbn(Isbn.valueOf(sale.getBookId()));
                response.customerId(CustomerId.valueOf(sale.getBookId()));
                response.timestamp(sale.getTimestamp());

                System.err.println("SALE_DOCUMENT_TO_GET_SALE_CONVERTER: "+response);
                return response.build();
            };

    private static final Converter<Sale, MakeSaleResponse>
            SALE_TO_MAKE_SALE_RESPONSE_CONVERTER =
            (context) -> {
                var sale = context.getSource();
                var response = new MakeSaleResponse();
                response.setSaleId(sale.getSaleId().getSaleId());
                response.setSaleDateTime(sale.getTimestamp());
                return response;
            };

    private static final Converter<MakeSaleRequest, Sale>
            MAKE_SALE_REQUEST_TO_SALE_CONVERTER =
            (context) -> {
                var request = context.getSource();
                return new Sale.Builder()
                        .saleId(request.getSaleId())
                        .isbn(Isbn.valueOf(request.getBookId()))
                        .customerId(CustomerId.valueOf(request.getCustomerId()))
                        .timestamp(request.getTimestamp())
                        .build();
            };

    private static final Converter<Publisher, PublisherResponse>
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

    private static final Converter<PublisherRequest, Publisher>
            ADD_PUBLISHER_REQUEST_TO_PUBLISH_CONVERTER =
            (context) -> {
                var request = context.getSource();
                return new Publisher.Builder()
                        .publisherId(request.getPublisherId())
                        .logo(request.getLogo())
                        .name(request.getFirstName(), request.getLastName())
                        .build();
            };




    @Bean
    public ModelMapper modelMapper() {
        var mapper = new ModelMapper();

       mapper.addConverter(SALE_TO_GET_SALE_RESPONSE_CONVERTER,
                Sale.class, SaleResponse.class);
        mapper.addConverter(SALE_DOCUMENT_TO_GET_SALE_CONVERTER,
                SaleDocument.class, Sale.class);
        mapper.addConverter(SALE_TO_MAKE_SALE_RESPONSE_CONVERTER,
               Sale.class, MakeSaleResponse.class);
        mapper.addConverter( MAKE_SALE_REQUEST_TO_SALE_CONVERTER ,
               MakeSaleRequest.class, Sale.class);
        mapper.addConverter(PUBLISHER_TO_ADD_PUBLISHER_RESPONSE_CONVERTER ,
                Publisher.class, PublisherResponse.class);
        mapper.addConverter(ADD_PUBLISHER_REQUEST_TO_PUBLISH_CONVERTER,
                PublisherRequest.class, Publisher.class);
        return mapper;
    }
}

