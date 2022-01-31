package com.example.sale.domain;


import com.example.sale.book.Book;

import java.util.Objects;
import java.sql.Timestamp;


public class Sale {
    private SaleId saleId;
    private Book book;
    private Customer customer;
    private Timestamp timestamp;

    private Sale(SaleId saleId) {
        this.saleId = saleId;
    }

    public SaleId getSaleId() {
        return saleId;
    }

    public Book getBook() {
        return book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setIsbn(Book book) {
        this.book = book;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setBook(Book book) {
        this.book = book;
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
                ", book=" + book +
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

        public Builder book(Book book){

            this.book=new Book.Builder()
                    .isbn(book.getIsbn().getValue())
                    .author(book.getAuthor().getValue())
                    .popularity(book.getPopularity().getValue())
                    .price(book.getPrice().getValue())
                    .coverPhoto(book.getCoverPhoto().getBase64Values())
                    .title(book.getTitle().getValue())
                    .contents(book.getContents().getValue())
                    .edition(book.getEdition().getValue())
                    .reviews(book.getReviews().getValue())
                    .build();
            return this;



            //this.isbn=BookRepository.GetById(value);
            //return this;
        }



        public Sale build(){
            Sale sale = new Sale(this.saleId);
            sale.setTimestamp(timestamp);
            sale.setCustomer(customer);
            sale.setIsbn(isbn);
            return sale;

        }


    }


}
