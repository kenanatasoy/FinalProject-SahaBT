package com.example.sale.domain;


import com.example.shared.domain.CustomerId;
import com.example.shared.domain.Isbn;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

//TODO customerId için gerekli işlemleri yapmayı unutma hem domain de hem standardServicede.
public class Sale {

    private SaleId saleId;
    private Isbn isbn;
    private CustomerId customerId;
    private LocalDateTime timestamp;

    private Sale(SaleId saleId, Isbn isbn, CustomerId customerId) {
        this.saleId = saleId;
        this.isbn = isbn;
        this.customerId = customerId;
        this.timestamp =  LocalDateTime.now();
    }

    public SaleId getSaleId() {
        return saleId;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setSaleId(SaleId saleId) {
        this.saleId = saleId;
    }

    public void setIsbn(Isbn isbn) {
        this.isbn = isbn;
    }

    public void setCustomerId(CustomerId customerId) {
        this.customerId = customerId;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(saleId, sale.saleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleId);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleId +
                ", isbn=" + isbn +
                ", customerId=" + customerId +
                ", localDate=" + timestamp +
                '}';
    }

    public static class Builder {
        private SaleId saleId;
        private Isbn isbn;
        private CustomerId customerId;
        private LocalDateTime timestamp;

        public Builder saleId(int saleId) {
            this.saleId = SaleId.valueOf(saleId);
            return this;
        }

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp =LocalDateTime.of(timestamp.toLocalDate(),timestamp.toLocalTime());
            return this;
        }

        public Builder isbn(Isbn isbn) {
            this.isbn = Isbn.valueOf(isbn.getValue());
            return this;
        }

        public Builder customerId(CustomerId customerId) {
            this.isbn = Isbn.valueOf(customerId.getValue());
            return this;
        }

        public Sale build() {
            Sale sale = new Sale(this.saleId,this.isbn,this.customerId);
            return sale;
        }

    }


}
