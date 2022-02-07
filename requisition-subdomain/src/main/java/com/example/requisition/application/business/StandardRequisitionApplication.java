package com.example.requisition.application.business;

import com.example.publisher.domain.PublisherId;
import com.example.requisition.application.RequisitionApplication;
import com.example.requisition.application.business.event.StockUnderCriticalLevelEvent;
import com.example.requisition.application.business.exception.RequisitionNotFoundException;
import com.example.requisition.domain.Requisition;
import com.example.requisition.domain.RequisitionId;
import com.example.requisition.infra.EventPublisher;
import com.example.requisition.repository.RequisitionRepository;
import com.example.sale.application.SaleApplication;
import com.example.stock.domain.Stock;
import com.example.stock.application.StockApplication;

import java.util.List;
import java.util.Optional;

public class StandardRequisitionApplication implements RequisitionApplication {

    private final RequisitionRepository requisitionRepository;
    private final SaleApplication saleService;
    private final StockApplication stockApplication;
    private final EventPublisher<StockUnderCriticalLevelEvent> eventPublisher;

    public StandardRequisitionApplication(RequisitionRepository requisitionRepository, SaleApplication saleService, StockApplication stockApplication, EventPublisher eventPublisher) {
        this.requisitionRepository = requisitionRepository;
        this.saleService = saleService;
        this.stockApplication = stockApplication;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Optional<Requisition> makeRequisition(Requisition requisition) {

        Stock bookStock = stockApplication.findStockByBookIsbn(requisition.getIsbn());
        long numberOfBooksLeft = bookStock.getNumberOfBooksLeft().getValue();
        long lastThreeMonthSaleCountOfBook = saleService.getNumberOfLastThreeMonthSalesByIsbn(requisition.getIsbn());
        
        if(numberOfBooksLeft < lastThreeMonthSaleCountOfBook){
            var bookRequisitionAmount = lastThreeMonthSaleCountOfBook - numberOfBooksLeft;
            StockUnderCriticalLevelEvent event = new StockUnderCriticalLevelEvent(bookRequisitionAmount, requisition.getIsbn());
            eventPublisher.publishEvent(event); // TODO What is unchecked call?
            return Optional.ofNullable(requisitionRepository.saveRequisition(requisition));
        }

        return Optional.empty();
    }

    @Override
    public Optional<Requisition> makeImmediateRequisition(Requisition requisition) {
        return Optional.ofNullable(requisitionRepository.saveRequisition(requisition));
    }


    @Override
    public Requisition findRequisitionById(RequisitionId requisitionId) {
        return requisitionRepository.findOneById(requisitionId)
                .orElseThrow(() -> new RequisitionNotFoundException("Requisition has not been found", requisitionId.getValue()));
    }

    @Override
    public List<Requisition> findAllRequisitions() {
        return requisitionRepository.findAllRequisitions();
    }

    @Override
    public Requisition clearRequisition(RequisitionId requisitionId) {
        Optional<Requisition> removedRequisition = requisitionRepository.deleteRequisition(requisitionId);
        return removedRequisition.orElseThrow(() -> new RequisitionNotFoundException(
                "Requisition does not exist", requisitionId.getValue()));
    }

    @Override
    public List<Requisition> findRequisitionsByPublisherId(PublisherId publisherId) {
        return requisitionRepository.findRequisitionsByPublisherId(publisherId);
    }


}
