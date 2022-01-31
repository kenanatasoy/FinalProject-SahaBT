package com.example.requisition.application;

import com.example.requisition.domain.Requisition;
import com.example.requisition.domain.RequisitionId;

import java.util.Optional;

public interface RequisitionApplication {

    Requisition makeOrder(Requisition order);
    Optional<Requisition> findOrderById(RequisitionId orderId);


}
