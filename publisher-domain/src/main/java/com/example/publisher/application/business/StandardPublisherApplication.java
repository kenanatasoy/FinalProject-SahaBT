package com.example.publisher.application.business;

import com.example.publisher.domain.Publisher;
import com.example.publisher.domain.PublisherId;
import com.example.publisher.repository.PublisherRepository;
import com.example.publisher.application.PublisherApplication;
import com.example.publisher.application.business.exception.ExistingPublisherException;
import com.example.publisher.application.business.exception.PublisherNotFoundException;
import com.example.requisition.application.RequisitionApplication;
import com.example.requisition.domain.RequisitionId;
import com.example.shared.domain.Isbn;
import com.example.stock.application.StockApplication;
import com.example.stock.domain.Stock;

import java.util.List;
import java.util.Optional;

public class StandardPublisherApplication implements PublisherApplication {

    private final PublisherRepository publisherRepository;
    private final RequisitionApplication requisitionApplication;
    private final StockApplication stockApplication;

    public StandardPublisherApplication(PublisherRepository publisherRepository, RequisitionApplication requisitionApplication, StockApplication stockApplication) {
        this.publisherRepository = publisherRepository;
        this.requisitionApplication = requisitionApplication;
        this.stockApplication = stockApplication;
    }

    public Publisher addPublisher(Publisher publisher) {
        PublisherId publisherId = publisher.getPublisherId();
        if (publisherRepository.ExistPublisherByPublisherId(publisherId))
            throw new ExistingPublisherException("Already exist,", publisherId.getPublisherId());
        return publisherRepository.savePublisher(publisher);
    }

    public Publisher deletePublisher(PublisherId publisherId) {
            Optional<Publisher> deletedPublisher=publisherRepository.delete(publisherId);
            var publisher= deletedPublisher.orElseThrow(()->new PublisherNotFoundException("Publisher does not exist",publisherId.getPublisherId()));
        return deletedPublisher.get();
    }


    @Override
    public void inspectRequisitions() {
        List<String> bookIds = requisitionApplication.findAllRequisitions().stream().map(r -> r.getIsbn().getValue()).toList();
        List<Stock> stocks = bookIds.stream().map(bookId ->
                stockApplication.findStockByBookIsbn(Isbn.valueOf(bookId)))
                .toList();
        stocks.forEach(stock -> supplyBook(stock.getIsbn(), stock.getNumberOfBooksSold().getValue()));

    }

    @Override
    public void supplyBook(Isbn isbn, int numberOfBooksToSupply) {
        Stock stock = stockApplication.findStockByBookIsbn(isbn);
        stock.addStock(numberOfBooksToSupply);
        stockApplication.updateStockInfo(stock);
        RequisitionId requisitionId = requisitionApplication.findRequisitionByBookId(isbn).getRequisitionId();
        requisitionApplication.clearRequisition(requisitionId);
    }


}
