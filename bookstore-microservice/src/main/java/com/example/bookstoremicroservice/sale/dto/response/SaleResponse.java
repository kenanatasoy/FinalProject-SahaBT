package com.example.bookstoremicroservice.sale.dto.response;

import java.time.LocalDateTime;

public class SaleResponse {

    private int saleId;
    private String bookId;
    private String customerId;
    private LocalDateTime saleDateTime;

    public SaleResponse() {
    }

    public int getSaleId() {
        return saleId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public LocalDateTime getSaleDateTime() {
        return saleDateTime;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setSaleDateTime(LocalDateTime saleDateTime) {
        this.saleDateTime = saleDateTime;
    }

    @Override
    public String toString() {
        return "SaleResponse{" +
                "saleId=" + saleId +
                ", bookId='" + bookId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", saleDateTime=" + saleDateTime +
                '}';
    }
}
