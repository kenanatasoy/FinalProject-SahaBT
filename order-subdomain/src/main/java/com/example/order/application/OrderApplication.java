package com.example.order.application;

import com.example.order.domain.Order;
import com.example.order.domain.OrderId;

import java.util.List;
import java.util.Optional;

public interface OrderApplication {

    Order makeOrder(Order order);
    Optional<Order> findOrderById(OrderId orderId);
    List<Order> findAllOrders();

}
