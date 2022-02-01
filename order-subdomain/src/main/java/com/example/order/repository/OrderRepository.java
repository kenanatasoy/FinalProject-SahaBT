package com.example.order.repository;

import com.example.order.domain.Order;
import com.example.order.domain.OrderId;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    
    boolean existsByOrderId(OrderId orderId);

    Order saveOrder(Order employee);

    Optional<Order> removeOrder(OrderId orderId);

    Optional<Order> findOrderById(OrderId orderId);

    List<Order> findAllOrders();

}
