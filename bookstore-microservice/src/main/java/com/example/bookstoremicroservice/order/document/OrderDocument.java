package com.example.bookstoremicroservice.order.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "orders")
public class OrderDocument {

    @Id
    private Long orderId;

    private String customerId;

    @Indexed
    private String isbn;

    public OrderDocument() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

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
        OrderDocument other = (OrderDocument) obj;
        return Objects.equals(orderId, other.orderId);
    }

    @Override
    public String toString() {
        return "OrderDocument{" +
                "orderId=" + orderId +
                ", customerId='" + customerId + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

}
