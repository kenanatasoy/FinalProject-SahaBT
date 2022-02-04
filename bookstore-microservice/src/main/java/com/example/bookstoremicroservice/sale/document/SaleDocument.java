package com.example.bookstoremicroservice.sale.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document(collection = "sales")
public class SaleDocument {

    @Id
    private int saleId;
    private LocalDateTime timestamp;
    @DBRef(db = "book")
    private String bookId;
    @DBRef(db = "customer")
    private String customerId;

    public SaleDocument() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleDocument that = (SaleDocument) o;
        return saleId == that.saleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleId);
    }

    @Override
    public String toString() {
        return "SaleDocument{" +
                "saleId=" + saleId +
                ", timestamp=" + timestamp +
                ", bookId='" + bookId + '\'' +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
