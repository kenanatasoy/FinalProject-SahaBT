package com.example.requisition.application;

import com.example.requisition.domain.Requisition;
import com.example.requisition.domain.RequisitionId;

import java.util.Optional;

public interface RequisitionApplication {

    Requisition makeRequisition(Requisition order);
    Optional<Requisition> findOrderById(RequisitionId orderId);


}
