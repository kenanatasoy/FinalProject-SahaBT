package com.example.bookstoremicroservice.sale.modelMapperConverters;

import com.example.bookstoremicroservice.sale.document.SaleDocument;
import com.example.bookstoremicroservice.sale.dto.request.MakeSaleRequest;
import com.example.bookstoremicroservice.sale.dto.response.MakeSaleResponse;
import com.example.bookstoremicroservice.sale.dto.response.SaleResponse;
import com.example.sale.domain.Sale;
import com.example.shared.domain.CustomerId;
import com.example.shared.domain.Isbn;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;

@Component
public class SaleConverters {

    public static final Converter<Sale, SaleResponse>
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

    public static final Converter<SaleDocument, Sale>
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

    public static final Converter<Sale, MakeSaleResponse>
            SALE_TO_MAKE_SALE_RESPONSE_CONVERTER =
            (context) -> {
                var sale = context.getSource();
                var response = new MakeSaleResponse();
                response.setSaleId(sale.getSaleId().getSaleId());
                response.setSaleDateTime(sale.getTimestamp());
                return response;
            };

    public static final Converter<MakeSaleRequest, Sale>
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


}
