package com.example.sale.domain;


import com.example.shared.domain.Isbn;

import java.sql.Timestamp;
import java.util.Objects;


public class Sale {
    private  SaleId saleId;
    private  Isbn isbn;
    private  CustomerId customerId;
    private  Timestamp timestamp;

    private Sale(SaleId saleId, Isbn isbn, CustomerId customerId) {
        this.saleId = saleId;
        this.isbn = isbn;
        this.customerId = customerId;
        this.timestamp = new Timestamp(System.currentTimeMillis());
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

    public Timestamp getTimestamp() {
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

    public void setTimestamp(Timestamp timestamp) {
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
                ", timestamp=" + timestamp +
                '}';
    }

    public static class Builder {
        private SaleId saleId;
        private Isbn isbn;
        private CustomerId customerId;
        private Timestamp timestamp;

        public Builder saleId(int saleId) {
            this.saleId = SaleId.valueOf(saleId);
            return this;
        }

        public Builder timestamp(Timestamp timestamp) {
            this.timestamp = Timestamp.valueOf(String.valueOf(timestamp));
            return this;
        }

        public Builder isbn(Isbn isbn) {
            this.isbn = Isbn.valueOf(isbn.getValue());
            return this;
        }


        public Sale build() {
            Sale sale = new Sale(this.saleId,this.isbn,this.customerId);

            return sale;

        }


    }


}
