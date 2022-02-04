package com.example.sale.application.business;


import com.example.sale.application.SaleApplication;
import com.example.sale.application.business.events.MakeSaleEvent;
import com.example.sale.application.business.events.SaleEvent;
import com.example.sale.application.business.exception.SaleNotFoundException;
import com.example.sale.domain.Sale;
import com.example.sale.domain.SaleId;
import com.example.sale.infrastructure.SaleEventPublisher;
import com.example.sale.repository.SaleRepository;
import com.example.shared.domain.CustomerId;
import com.example.shared.domain.Isbn;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StandardSaleApplication implements SaleApplication {

    private final SaleRepository saleRepository;
    private final SaleEventPublisher<SaleEvent> saleEventPublisher;

    public StandardSaleApplication(SaleRepository saleRepository, SaleEventPublisher<SaleEvent> saleEventPublisher) {
        this.saleRepository = saleRepository;
        this.saleEventPublisher = saleEventPublisher;
    }

    @Override
    public Optional<Sale> getBySaleId(SaleId saleId) {
        if (saleRepository.findBySaleId(saleId).isPresent())
            throw new SaleNotFoundException("Sale not found, ", saleId.getSaleId());
        return saleRepository.findBySaleId(saleId);
    }

    @Override
    public List<Sale> getSalesByBookId(Isbn isbn) {

        return saleRepository.findSalesByBookIsbn(isbn);
    }


    @Override
    public List<Sale> getByCustomerId(CustomerId customerId) {

        return saleRepository.findSalesByCustomerId(customerId);
    }

    @Override
    public Sale makeSale(Sale sale, int amount) {
        var saleId = sale.getSaleId();
        if (saleRepository.existBySaleId(saleId))
            throw new SaleNotFoundException("sale already exists", saleId.getSaleId());
        Sale savedSale = saleRepository.saveSale(sale);
        var businessEvent = new MakeSaleEvent(savedSale, amount);
        saleEventPublisher.publishEvent(businessEvent);
        return savedSale;
    }

    @Override
    public List<Sale> listSales() {
        return saleRepository.listSales();
    }

    @Override
    public List<Sale> findSalesByPages(int page, int size) {
        return saleRepository.findSalesByPages(page,size);
    }

//    @Override
//    public List<Sale> getLastThreeMonthSales() {
//        return saleRepository.listSales().stream()
//                .filter((s) -> s.getTimestamp().isAfter(LocalDateTime.now().minusMonths(3)))
//                .collect(Collectors.toList());
//
//    }

//    @Override
//    public long getNumberOfLastThreeMonthSales() {
//        return getLastThreeMonthSales().size();
//    }

    @Override
    public List<Sale> getLastThreeMonthSalesByIsbn(Isbn isbn) {
        return saleRepository.listSales().stream()
                .filter((s) -> s.getIsbn().equals(isbn))
                .filter((s) -> s.getTimestamp().isAfter(LocalDateTime.now().minusMonths(3)))
                .collect(Collectors.toList());
    }

    @Override
    public long getNumberOfLastThreeMonthSalesByIsbn(Isbn isbn) {
        return getLastThreeMonthSalesByIsbn(isbn).size();
    }


}
