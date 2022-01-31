package com.example.order.application;

import com.example.order.domain.Order;
import com.example.order.domain.OrderId;

import java.util.Optional;

public interface OrderApplication {
    Order makeOrder(Order order);
    Optional<Order> findOrderById(OrderId orderId);
}
