package com.example.bookstoremicroservice.requisition.service;

import com.example.bookstoremicroservice.requisition.dto.request.RequisitionRequest;
import com.example.bookstoremicroservice.requisition.dto.response.RequisitionResponse;

import java.util.List;
import java.util.Optional;

public interface RequisitionService {

    Optional<RequisitionResponse> makeRequisition(RequisitionRequest requisitionRequest);
    Optional<RequisitionResponse> makeImmediateRequisition(RequisitionRequest requisitionRequest);
    RequisitionResponse findRequisitionById(Long requisitionId);
    List<RequisitionResponse> findAllRequisitions();
    RequisitionResponse clearRequisition(Long requisitionId);
    List<RequisitionResponse> findRequisitionsByPublisherId(Long publisherId);

}
