package com.example.sale.service.business;

import com.example.sale.service.SaleService;
import com.example.sale.service.business.exception.SaleNotFoundException;
import com.example.domain.book.Isbn;
import com.example.sale.domain.Sale;
import com.example.sale.domain.SaleId;
import com.example.sale.repository.SaleRepository;

import java.util.List;

public class StandardSaleService implements SaleService {


    private final SaleRepository saleRepository;

    public  StandardSaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale getBySaleId(SaleId saleId) {
       if(saleRepository.existBySaleId(saleId))
           throw new SaleNotFoundException("Sale not found, " , saleId.getSaleId());

        return saleRepository.findBySaleId(saleId).get();

    }

    @Override
    public List<Sale> getByBookId(Isbn isbn) {

        return saleRepository.findByBookIsbn(isbn);
    }
    //TODO customer için de getByCustomerId yapılacak.

    @Override
    public Sale makeSale(Sale sale) {
        var saleId = sale.getSaleId();
        if(saleRepository.existBySaleId(saleId))
            throw new SaleNotFoundException("Order already exists", saleId.getSaleId());
        Sale savedSale = saleRepository.saveSale(sale);
        //TODO stock-domain yazıldığında burada kitap satılınca stockdan düşecek kodu yaz.
        return savedSale;
    }

    @Override
    public List<Sale> listSales() {
        return saleRepository.listSales();
    }




}
