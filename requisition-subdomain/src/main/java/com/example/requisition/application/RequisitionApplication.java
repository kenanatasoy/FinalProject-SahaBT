package com.example.requisition.application;

import com.example.requisition.application.business.domain.Requisition;
import com.example.requisition.application.business.domain.RequisitionId;

import java.util.List;

public interface RequisitionApplication {

    Requisition makeRequisition(Requisition requisition);
    Requisition findRequisitionById(RequisitionId requisitionId);
    List<Requisition> findAllRequisitions();
    Requisition clearRequisition(RequisitionId requisitionId);
    List<Requisition> findRequisitionsByPublisherId(PublisherId publisherId);

}
