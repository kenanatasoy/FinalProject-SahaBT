package com.example.requisition.repository;

import com.example.publisher.domain.PublisherId;
import com.example.requisition.domain.Requisition;
import com.example.requisition.domain.RequisitionId;
import com.example.shared.domain.Isbn;

import java.util.List;
import java.util.Optional;

public interface RequisitionRepository {

    Boolean existsByRequisitionId(RequisitionId requisitionId);

    Requisition saveRequisition(Requisition requisition);

    Optional<Requisition> findRequisitionByBookId(Isbn isbn);

    void removeRequisition(RequisitionId requisitionId);

    Optional<Requisition> findOneById(RequisitionId requisitionId);

    List<Requisition> findAllRequisitions();

    List<Requisition> findRequisitionsByPublisherId(PublisherId publisherId);

}
