package com.example.bookstoremicroservice.requisition.adapter;

import com.example.bookstoremicroservice.requisition.document.RequisitionDocument;
import com.example.bookstoremicroservice.requisition.repository.RequisitionDocumentMongoRepository;
import com.example.bookstoremicroservice.stock.document.StockDocument;
import com.example.bookstoremicroservice.stock.repository.StockDocumentMongoRepository;
import com.example.publisher.domain.PublisherId;
import com.example.requisition.domain.Requisition;
import com.example.requisition.domain.RequisitionId;
import com.example.requisition.repository.RequisitionRepository;
import com.example.shared.domain.Isbn;
import com.example.stock.domain.Stock;
import com.example.stock.domain.StockKeepingUnit;
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
        return mongoRepo.findByIsbn(isbn.getValue());
    }

    @Override
    public Optional<Requisition> removeRequisition(RequisitionId requisitionId) {
        return Optional.empty();
    }

    @Override
    public Optional<Requisition> findOneById(RequisitionId requisitionId) {
        return Optional.empty();
    }

    @Override
    public List<Requisition> findAllRequisitions() {
        return null;
    }

    @Override
    public Optional<Requisition> deleteRequisition(RequisitionId requisitionId) {
        return Optional.empty();
    }

    @Override
    public List<Requisition> findRequisitionsByPublisherId(PublisherId publisherId) {
        return null;
    }


}
