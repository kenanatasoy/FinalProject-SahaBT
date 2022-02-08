package com.example.bookstoremicroservice.requisition.adapter;

import com.example.bookstoremicroservice.requisition.document.RequisitionDocument;
import com.example.bookstoremicroservice.requisition.repository.RequisitionDocumentMongoRepository;
import com.example.publisher.domain.PublisherId;
import com.example.requisition.application.business.exception.RequisitionNotFoundException;
import com.example.requisition.domain.Requisition;
import com.example.requisition.domain.RequisitionId;
import com.example.requisition.repository.RequisitionRepository;
import com.example.shared.domain.Isbn;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RequisitionRepositoryMongoAdapter implements RequisitionRepository {

    private final RequisitionDocumentMongoRepository mongoRepo;
    private final ModelMapper modelMapper;

    public RequisitionRepositoryMongoAdapter(RequisitionDocumentMongoRepository mongoRepo, ModelMapper modelMapper) {
        this.mongoRepo = mongoRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean existsByRequisitionId(RequisitionId requisitionId) {
        return mongoRepo.existsById(requisitionId.getValue());
    }

    @Override
    public Requisition saveRequisition(Requisition requisition) {
        var requisitionDocument = modelMapper.map(requisition, RequisitionDocument.class);
        return modelMapper.map(mongoRepo.save(requisitionDocument), Requisition.class);
    }

    @Override
    public Optional<Requisition> findRequisitionByBookId(Isbn isbn) {
        return Optional.ofNullable(modelMapper.map(mongoRepo.findByIsbn(isbn.getValue()), Requisition.class));
    }

    @Override
    public void removeRequisition(RequisitionId requisitionId) {
        mongoRepo.deleteById(requisitionId.getValue());
    }

    @Override
    public Optional<Requisition> findOneById(RequisitionId requisitionId) {
        var requisitionDocumentOptional = mongoRepo.findById(requisitionId.getValue());
        if (requisitionDocumentOptional.isEmpty()){
            throw new RequisitionNotFoundException("Requisition document is not found", requisitionId.getValue());
        }
        return Optional.ofNullable(modelMapper.map(requisitionDocumentOptional.get(), Requisition.class));
    }

    @Override
    public List<Requisition> findAllRequisitions() {
        return mongoRepo.findAll().stream().map(
                requisitionDocument -> modelMapper.map(requisitionDocument, Requisition.class)
        ).toList();
    }

    @Override
    public List<Requisition> findRequisitionsByPublisherId(PublisherId publisherId) {
        return mongoRepo.findAllByPublisherId(publisherId.getPublisherId()).stream().map(
                requisitionDocument -> modelMapper.map(requisitionDocument, Requisition.class)
        ).toList();
    }


}
