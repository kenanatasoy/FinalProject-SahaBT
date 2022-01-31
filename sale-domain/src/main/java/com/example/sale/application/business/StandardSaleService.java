package com.example.sale.application.business;

import com.example.sale.application.SaleService;
import com.example.sale.application.business.exception.SaleNotFoundException;
import com.example.domain.book.Isbn;
import com.example.sale.domain.Sale;
import com.example.sale.domain.SaleId;
import com.example.sale.repository.SaleRepository;

public class StandardSaleService implements SaleService {

    private SaleRepository saleRepository;

    public StandardSaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale getBySaleId(SaleId saleId) {
       if(saleRepository.existBySaleId(saleId))
           throw new SaleNotFoundException("Sale not found, " , saleId.getSaleId());

       var sale=saleRepository.findBySaleId(saleId).get();
       return sale;


    }

    @Override
    public Sale getByBookId(Isbn isbn) {
        return null;
    }

    @Override
    public Sale makeSale(Sale sale) {
        var saleId = sale.getSaleId();
        if(saleRepository.existBySaleId(saleId))
            throw new SaleNotFoundException("Order already exists", saleId.getSaleId());
        Sale savedSale = saleRepository.saveSale(sale);
        return savedSale;
    }
}
