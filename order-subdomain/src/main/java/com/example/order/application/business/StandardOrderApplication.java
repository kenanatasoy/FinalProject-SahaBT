package com.example.order.application.business;

import com.example.order.application.OrderApplication;
import com.example.order.application.business.event.OrderMadeEvent;
import com.example.order.application.business.exception.ExistingOrderException;
import com.example.order.domain.Order;
import com.example.order.domain.OrderId;
import com.example.order.infra.EventPublisher;
import com.example.order.repository.OrderRepository;

import java.util.Optional;

public class StandardOrderApplication implements OrderApplication {

    private OrderRepository orderRepository;
    private EventPublisher eventPublisher;

    public StandardOrderApplication(OrderRepository orderRepository, EventPublisher eventPublisher) {
        this.orderRepository = orderRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Order makeOrder(Order order) {
        var orderId = order.getOrderId();
        if(orderRepository.existsByOrderId(orderId))
            throw new ExistingOrderException("Order already exists", orderId.getValue());
        Order savedOrder = orderRepository.saveOrder(order);
        var orderMadeEvent = new OrderMadeEvent(savedOrder);
        eventPublisher.publishEvent(orderMadeEvent);
        return savedOrder;
    }

    @Override
    public Optional<Order> findOrderById(OrderId orderId) {
        return orderRepository.findOrderById(orderId);
    }
}
