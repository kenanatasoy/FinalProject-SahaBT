package com.example.requisition.application.business;

import com.example.requisition.application.RequisitionApplication;
import com.example.requisition.application.business.exception.RequisitionNotFoundException;
import com.example.requisition.domain.Requisition;
import com.example.requisition.domain.RequisitionId;
import com.example.requisition.repository.RequisitionRepository;

import java.util.List;
import java.util.Optional;

public class StandardRequisitionApplication implements RequisitionApplication {

    private final RequisitionRepository requisitionRepository;

    public StandardRequisitionApplication(RequisitionRepository requisitionRepository) {
        this.requisitionRepository = requisitionRepository;
    }

    @Override
    public Requisition makeRequisition(Requisition requisition) {
        return null;
    }

    @Override
    public Requisition findRequisitionById(RequisitionId requisitionId) {
        return requisitionRepository.findOneById(requisitionId)
                .orElseThrow(() -> new RequisitionNotFoundException("Requisition has not been found", requisitionId.getValue()));
    }

    @Override
    public List<Requisition> findAllRequisitions() {
        return null;
    }

    @Override
    public Requisition clearRequisition(RequisitionId requisitionId) {
        Optional<Requisition> removedRequisition = requisitionRepository.deleteRequisition(requisitionId);
        var requisition = removedRequisition.orElseThrow(() -> new RequisitionNotFoundException(
                "Requisition does not exist", requisitionId.getValue()));
//        eventPublisher.publishEvent(new RequisitionClearedEvent(requisition));
        return requisition;
    }
}
