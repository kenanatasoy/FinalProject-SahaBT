package com.example.bookstoremicroservice.sale.dto.request;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class MakeSaleRequest {

    @Id
    private int saleId;
    private LocalDateTime timestamp;
    private String bookId;
    private String customerId;

    public MakeSaleRequest() {
    }

    public int getSaleId() {
        return saleId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getBookId() {
        return bookId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "SaleRequest{" +
                "saleId=" + saleId +
                ", timestamp=" + timestamp +
                ", bookId='" + bookId + '\'' +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
