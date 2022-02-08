package com.example.bookstoremicroservice.requisition.service.business;

import com.example.bookstoremicroservice.requisition.dto.request.RequisitionRequest;
import com.example.bookstoremicroservice.requisition.dto.response.RequisitionResponse;
import com.example.bookstoremicroservice.requisition.service.RequisitionService;
import com.example.requisition.application.RequisitionApplication;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StandardRequisitionService implements RequisitionService {

    private final RequisitionApplication requisitionApplication;
    private final ModelMapper modelMapper;

    //TODO

    public StandardRequisitionService(RequisitionApplication requisitionApplication, ModelMapper modelMapper) {
        this.requisitionApplication = requisitionApplication;
        this.modelMapper = modelMapper;
    }

    //TODO

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
