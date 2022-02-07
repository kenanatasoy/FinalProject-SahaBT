package com.example.requisition.application;

import com.example.publisher.domain.PublisherId;
import com.example.requisition.domain.Requisition;
import com.example.requisition.domain.RequisitionId;
import com.example.shared.domain.Isbn;

import java.util.List;
import java.util.Optional;

public interface RequisitionApplication {

    Optional<Requisition> makeRequisition(Requisition requisition);
    Optional<Requisition> makeImmediateRequisition(Requisition requisition);
    Requisition findRequisitionById(RequisitionId requisitionId);
    Requisition findRequisitionByBookId(Isbn isbn);
    List<Requisition> findAllRequisitions();
    Requisition clearRequisition(RequisitionId requisitionId);
    List<Requisition> findRequisitionsByPublisherId(PublisherId publisherId);


}
