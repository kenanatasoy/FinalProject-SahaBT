package com.example.bookstoremicroservice.config;

import com.example.bookstoremicroservice.document.SaleDocument;
import com.example.bookstoremicroservice.dto.response.SaleResponse;
import com.example.sale.domain.Sale;
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
                var saleId = sale.getSaleId();
                var response = new Sale.Builder();
                response.saleId(sale.getSaleId());
                response.isbn(Isbn.valueOf(sale.getBookId()));
                response.customerId(CustomerId.valueOf(sale.getBookId()));
                response.timestamp(sale.getTimestamp());

                System.err.println("SALE_DOCUMENT_TO_GET_SALE_CONVERTER: "+response);
                return response.build();
            };

    @Bean
    public ModelMapper modelMapper() {
        var mapper = new ModelMapper();

       mapper.addConverter(SALE_TO_GET_SALE_RESPONSE_CONVERTER,
                Sale.class, SaleResponse.class);
//        mapper.addConverter(EMPLOYEE_DOCUMENT_TO_EMPLOYEE_CONVERTER,
//                EmployeeDocument.class, Employee.class);
//        mapper.addConverter(EMPLOYEE_TO_GET_EMPLOYEE_RESPONSE_CONVERTER,
//                Employee.class, GetEmployeeResponse.class);
//        mapper.addConverter(EMPLOYEE_TO_FIRE_EMPLOYEE_RESPONSE_CONVERTER,
//                Employee.class, FireEmployeeResponse.class);
//        mapper.addConverter(EMPLOYEE_TO_HIRE_EMPLOYEE_RESPONSE_CONVERTER,
//                Employee.class, HireEmployeeResponse.class);
//        mapper.addConverter(HIRE_EMPLOYEE_REQUEST_TO_EMPLOYEE_CONVERTER,
//                HireEmployeeRequest.class, Employee.class);
        return mapper;
    }
}

