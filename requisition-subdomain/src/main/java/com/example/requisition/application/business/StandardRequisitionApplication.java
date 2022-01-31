package com.example.requisition.application.business;

import com.example.requisition.application.RequisitionApplication;
import com.example.requisition.domain.Requisition;
import com.example.requisition.domain.RequisitionId;

import java.util.Optional;

public class StandardRequisitionApplication implements RequisitionApplication {

    @Override
    public Requisition makeOrder(Requisition order) {
        return null;
    }

    @Override
    public Optional<Requisition> findOrderById(RequisitionId orderId) {
        return Optional.empty();
    }
}
