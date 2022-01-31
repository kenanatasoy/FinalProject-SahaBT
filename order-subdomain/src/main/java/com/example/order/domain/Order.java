package com.example.order.domain;

import com.example.domain.book.Book;

import java.util.Objects;

public class Order {

    private final OrderId orderId;
    private final Customer customer;
    private final Book book;

    private Order(OrderId orderId, Customer customer, Book book) {
        this.orderId = orderId;
        this.customer = customer;
        this.book = book;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Book getBook() {
        return book;
    }


//    public StockNumber addStock(int newItems) {
//        this.numberOfBooksLeft = numberOfBooksLeft.add(newItems);
//        return numberOfBooksLeft;
//    }
//
//    public StockNumber sellFromStock(int soldItems) {
//        this.numberOfBooksLeft = numberOfBooksLeft.drop(soldItems);
//        numberOfBooksSold = numberOfBooksSold.add(soldItems);
//        return numberOfBooksLeft;
//    }


    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        return Objects.equals(orderId, other.orderId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", book=" + book +
                '}';
    }

    public static class Builder {

        private OrderId orderId;
        private Customer customer;
        private Book book;

        public Builder orderId(String value) {
            this.orderId = OrderId.of(value);
            return this;
        }

        public Builder customer(Customer customer) {
            this.customer = Customer.valueOf(value);
            return this;
        }

        public Builder book(Book book){
            this.book = Book.valueOf(book);
            return this;
        }

        public Order build() {
            var order = new Order(orderId, customer, book);
            return order;
        }

    }


}