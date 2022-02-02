package com.example.requisition.application;

import com.example.publisher.domain.PublisherId;
import com.example.requisition.application.business.domain.Requisition;
import com.example.requisition.application.business.domain.RequisitionId;

import java.util.List;
import java.util.Optional;

public interface RequisitionApplication {

    Optional<Requisition> makeRequisition(Requisition requisition);
    Requisition findRequisitionById(RequisitionId requisitionId);
    List<Requisition> findAllRequisitions();
    Requisition clearRequisition(RequisitionId requisitionId);
    List<Requisition> findRequisitionsByPublisherId(PublisherId publisherId);


}
