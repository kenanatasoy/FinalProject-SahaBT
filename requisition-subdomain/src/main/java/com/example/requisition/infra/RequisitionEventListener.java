package com.example.requisition.infra;

import com.example.order.application.business.event.OrderMadeEvent;
import com.example.order.domain.Order;

public interface RequisitionEventListener {

    default void onApplicationEvent(OrderMadeEvent event) {
        Order order = event.getOrder();
        System.out.println("Call makeOrder method from service in this interface's implementation");
    }
    
}
