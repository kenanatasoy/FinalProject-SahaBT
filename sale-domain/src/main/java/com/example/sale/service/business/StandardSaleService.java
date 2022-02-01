package com.example.sale.service.business;

import com.example.domain.book.Isbn;
import com.example.sale.domain.Sale;
import com.example.sale.domain.SaleId;
import com.example.sale.repository.SaleRepository;
import com.example.sale.service.SaleService;
import com.example.sale.service.business.exception.SaleNotFoundException;
import com.example.stock.domain.StockNumber;
import com.example.stock.service.StockService;

import java.util.List;

public class StandardSaleService implements SaleService {


    private final SaleRepository saleRepository;
    private final StockService stockService;

    public StandardSaleService(SaleRepository saleRepository, StockService stockService) {
        this.saleRepository = saleRepository;
        this.stockService = stockService;
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
    public Sale makeSale(Sale sale) {
        var saleId = sale.getSaleId();
        if (saleRepository.existBySaleId(saleId))
            throw new SaleNotFoundException("Order already exists", saleId.getSaleId());
        Sale savedSale = saleRepository.saveSale(sale);
        //TODO stock-domain yazıldığında burada kitap satılınca stockdan düşecek kodu yaz.

      //  var stock = stockService.findStockByBookIsbn(sale.getBook().getIsbn());
     //   stock.sellFromStock(StockNumber.of(1).getValue());

      //  stockService.updateStockInfo(stock);
        //TODO burası komple hocaya sorulacak.
        return savedSale;
    }

    @Override
    public List<Sale> listSales() {
        return saleRepository.listSales();
    }


}
