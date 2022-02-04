package com.example.order.domain;

import com.example.shared.domain.CustomerId;
import com.example.shared.domain.Isbn;

import java.util.Objects;

public class Order {

    private final OrderId orderId;
    private final CustomerId customerId;
    private final Isbn isbn;

    private Order(OrderId orderId, CustomerId customerId, Isbn isbn) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.isbn = isbn;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public Isbn getIsbn() {
        return isbn;
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
                ", customerId=" + customerId +
                ", isbn=" + isbn +
                '}';
    }

    public static class Builder {

        private OrderId orderId;
        private CustomerId customerId;
        private Isbn isbn;

        public Builder orderId(Long value) {
            this.orderId = OrderId.of(value);
            return this;
        }

        public Builder customer(CustomerId customerId) {
            this.customerId = CustomerId.valueOf(customerId.getValue());
            return this;
        }

        public Builder isbn(Isbn isbn){
            this.isbn = Isbn.valueOf(isbn.getValue());
            return this;
        }

        public Order build() {
            return new Order(orderId, customerId, isbn);
        }

    }


}