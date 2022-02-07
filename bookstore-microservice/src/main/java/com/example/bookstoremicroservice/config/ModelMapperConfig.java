package com.example.bookstoremicroservice.config;

import com.example.bookstoremicroservice.catalog.document.BookDocument;
import com.example.bookstoremicroservice.publisher.dto.request.PublisherRequest;
import com.example.bookstoremicroservice.publisher.dto.response.PublisherResponse;
import com.example.bookstoremicroservice.sale.document.SaleDocument;
import com.example.bookstoremicroservice.sale.dto.request.MakeSaleRequest;
import com.example.bookstoremicroservice.sale.dto.response.MakeSaleResponse;
import com.example.bookstoremicroservice.sale.dto.response.SaleResponse;
import com.example.domain.book.Book;
import com.example.publisher.domain.Publisher;
import com.example.sale.domain.Sale;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import static com.example.bookstoremicroservice.publisher.modelMapperConverters.PublisherConverters.*;
import static com.example.bookstoremicroservice.sale.modelMapperConverters.SaleConverters.*;
import static com.example.bookstoremicroservice.catalog.modelMapperConverters.BookConverters.*;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var mapper = new ModelMapper();

        // sale converters
        mapper.addConverter(SALE_TO_GET_SALE_RESPONSE_CONVERTER,
                Sale.class, SaleResponse.class);
        mapper.addConverter(SALE_DOCUMENT_TO_GET_SALE_CONVERTER,
                SaleDocument.class, Sale.class);
        mapper.addConverter(SALE_TO_MAKE_SALE_RESPONSE_CONVERTER,
               Sale.class, MakeSaleResponse.class);
        mapper.addConverter(MAKE_SALE_REQUEST_TO_SALE_CONVERTER ,
               MakeSaleRequest.class, Sale.class);

        //publisher converters
        mapper.addConverter(PUBLISHER_TO_ADD_PUBLISHER_RESPONSE_CONVERTER ,
                Publisher.class, PublisherResponse.class);
        mapper.addConverter(ADD_PUBLISHER_REQUEST_TO_PUBLISH_CONVERTER,
                PublisherRequest.class, Publisher.class);


        //stock converters

        //Book converters

        mapper.addConverter(BOOK_DOCUMENT_TO_BOOK_CONVERTER,
                BookDocument.class, Book.class);











        //Category converters

        return mapper;
    }
}

