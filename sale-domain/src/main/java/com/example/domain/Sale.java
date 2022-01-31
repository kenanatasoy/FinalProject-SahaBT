package com.example.domain;


import com.example.domain.book.Book;

import java.util.Objects;
import java.sql.Timestamp;


public class Sale {
    private SaleId saleId;
    private Book isbn;
    private Customer customer;
    private Timestamp timestamp;

    private Sale(SaleId saleId) {
        this.saleId = saleId;
    }

    public SaleId getSaleId() {
        return saleId;
    }

    public Book getBook() {
        return isbn;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Timestamp getTimestamp() {
        return timestamp;
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
                ", book=" + isbn +
                ", customer=" + customer +
                ", timestamp=" + timestamp +
                '}';
    }

    public static class Builder{
        private SaleId saleId;
        private Book book;
        private Customer customer;
        private Timestamp timestamp;

        public Builder saleId(int saleId){
            this.saleId=SaleId.valueOf(saleId);
            return this;
        }

        public Builder timestamp(Timestamp timestamp){
            this.timestamp=Timestamp.valueOf(String.valueOf(timestamp));
            return this;
        }


    }


}
