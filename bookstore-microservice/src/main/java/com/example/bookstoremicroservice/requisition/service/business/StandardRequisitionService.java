package com.example.bookstoremicroservice.requisition.service.business;

import com.example.bookstoremicroservice.requisition.dto.request.RequisitionRequest;
import com.example.bookstoremicroservice.requisition.dto.response.RequisitionResponse;
import com.example.bookstoremicroservice.requisition.service.RequisitionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StandardRequisitionService implements RequisitionService {

    @Override
    public Optional<RequisitionResponse> makeRequisition(RequisitionRequest requisitionRequest) {
        return Optional.empty();
    }

    @Override
    public Optional<RequisitionResponse> makeImmediateRequisition(RequisitionRequest requisitionRequest) {
        return Optional.empty();
    }

    @Override
    public RequisitionResponse findRequisitionById(Long requisitionId) {
        return null;
    }

    @Override
    public List<RequisitionResponse> findAllRequisitions() {
        return null;
    }

    @Override
    public RequisitionResponse clearRequisition(Long requisitionId) {
        return null;
    }

    @Override
    public List<RequisitionResponse> findRequisitionsByPublisherId(Long publisherId) {
        return null;
    }
}
