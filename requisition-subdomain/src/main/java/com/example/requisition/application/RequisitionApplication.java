package com.example.requisition.application;

import com.example.requisition.domain.Requisition;
import com.example.requisition.domain.RequisitionId;

import java.util.List;

public interface RequisitionApplication {

    Requisition makeRequisition(Requisition requisition);
    Requisition findRequisitionById(RequisitionId requisitionId);
    List<Requisition> findAllRequisitions();
    Requisition clearRequisition(RequisitionId requisitionId);

}
