package com.example.requisition.repository;

import com.example.requisition.domain.Requisition;
import com.example.requisition.domain.RequisitionId;

import java.util.Optional;

public interface RequisitionRepository {

    boolean existsByRequisitionId(RequisitionId requisitionId);

    Requisition saveRequisition(Requisition employee);

    Optional<Requisition> removeRequisition(RequisitionId requisitionId);

    Optional<Requisition> findOneById(RequisitionId requisitionId);


}
