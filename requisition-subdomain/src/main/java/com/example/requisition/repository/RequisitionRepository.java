package com.example.requisition.repository;

import com.example.publisher.domain.PublisherId;
import com.example.requisition.application.business.domain.Requisition;
import com.example.requisition.application.business.domain.RequisitionId;

import java.util.List;
import java.util.Optional;

public interface RequisitionRepository {

    Boolean existsByRequisitionId(RequisitionId requisitionId);

    Requisition saveRequisition(Requisition requisition);

    Optional<Requisition> removeRequisition(RequisitionId requisitionId);

    Optional<Requisition> findOneById(RequisitionId requisitionId);

    List<Requisition> findAllRequisitions();

    Optional<Requisition> deleteRequisition(RequisitionId requisitionId);

    List<Requisition> findRequisitionsByPublisherId(PublisherId publisherId);

}
