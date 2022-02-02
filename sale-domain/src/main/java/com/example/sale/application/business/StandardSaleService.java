package com.example.sale.application.business;


import com.example.sale.domain.Sale;
import com.example.sale.domain.SaleId;
import com.example.sale.infrastructure.EventPublisher;
import com.example.sale.repository.SaleRepository;
import com.example.sale.application.SaleService;
import com.example.sale.application.business.events.MakeSaleEvent;
import com.example.sale.application.business.exception.SaleNotFoundException;
import com.example.shared.domain.Isbn;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class StandardSaleService implements SaleService {


    private final SaleRepository saleRepository;
  private EventPublisher eventPublisher;

    public StandardSaleService(SaleRepository saleRepository,EventPublisher eventPublisher) {
        this.saleRepository = saleRepository;
        this.eventPublisher=eventPublisher;

    }

    @Override
    public Sale getBySaleId(SaleId saleId) {
        if (saleRepository.existBySaleId(saleId))
            throw new SaleNotFoundException("Sale not found, ", saleId.getSaleId());

        return saleRepository.findBySaleId(saleId).get();

    }

    @Override
    public List<Sale> getByBookId(Isbn isbn) {

        return saleRepository.findByBookIsbn(isbn);
    }
    //TODO customer için de getByCustomerId yapılacak.
    @Override
    public List<Sale> getByCustomerId(Identity customerId)
    {

        return saleRepository.findByCustomerId(customerId);
    }

    @Override
    public Sale makeSale(Sale sale,int amount) {
        var saleId = sale.getSaleId();
        if (saleRepository.existBySaleId(saleId))
            throw new SaleNotFoundException("Order already exists", saleId.getSaleId());
        Sale savedSale = saleRepository.saveSale(sale);
        var businessEvent= new MakeSaleEvent(savedSale,amount);
        eventPublisher.publishEvent(businessEvent);
        return savedSale;
    }

    @Override
    public List<Sale> listSales() {
        return saleRepository.listSales();
    }

    @Override
    public List<Sale> getLastThreeMonthSale() {

        return saleRepository.listSales().stream()
                .filter((s) -> s.getTimestamp().isAfter(LocalDateTime.now().minusMonths(3)))
                .toList();
        //TODO .collect(Collectors.toList());
    }


}
