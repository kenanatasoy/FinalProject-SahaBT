package com.example.bookstoremicroservice.dto.request;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;

public class SaleRequest {

    private int saleId;
    private LocalDateTime timestamp;
    private String bookId;
    private String customerId;

}
