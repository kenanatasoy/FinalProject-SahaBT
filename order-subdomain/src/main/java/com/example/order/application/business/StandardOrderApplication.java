package com.example.order.application.business;

import com.example.order.application.OrderApplication;
import com.example.order.application.business.event.OrderMadeEvent;
import com.example.order.application.business.exception.ExistingOrderException;
import com.example.order.application.business.exception.NoAmountLeftAtStockException;
import com.example.order.domain.Order;
import com.example.order.domain.OrderId;
import com.example.order.infra.OrderEventPublisher;
import com.example.order.repository.OrderRepository;
import com.example.stock.application.StockApplication;

import java.util.List;
import java.util.Optional;

public class StandardOrderApplication implements OrderApplication {

    private final OrderRepository orderRepository;
    private final OrderEventPublisher orderEventPublisher;
    private final StockApplication stockApplication;

    public StandardOrderApplication(OrderRepository orderRepository, OrderEventPublisher orderEventPublisher, StockApplication stockApplication) {
        this.orderRepository = orderRepository;
        this.orderEventPublisher = orderEventPublisher;
        this.stockApplication = stockApplication;
    }

    @Override
    public Order makeOrder(Order order) {

        long numberOfBooksLeft = stockApplication.findStockByBookIsbn(order.getIsbn()).getNumberOfBooksLeft().getValue();
        if (numberOfBooksLeft <= 0){
            throw new NoAmountLeftAtStockException("No amount left at stock", order.getOrderId().getValue());
        }
        var orderId = order.getOrderId();
        if(orderRepository.existsByOrderId(orderId))
            throw new ExistingOrderException("Order already exists", orderId.getValue());
        Order savedOrder = orderRepository.saveOrder(order);
        var orderMadeEvent = new OrderMadeEvent(savedOrder);
        orderEventPublisher.publishEvent(orderMadeEvent);
        return savedOrder;
    }



    @Override

    public Optional<Order> findOrderById(OrderId orderId) {
        return orderRepository.findOrderById(orderId);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAllOrders();
    }

}
