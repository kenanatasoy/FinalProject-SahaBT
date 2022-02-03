package com.example.bookstoremicroservice.adapter;

import com.example.bookstoremicroservice.document.SaleDocument;
import com.example.bookstoremicroservice.service.repository.SaleDocumentRepository;
import com.example.sale.domain.Sale;
import com.example.sale.domain.SaleId;
import com.example.sale.repository.SaleRepository;
import com.example.shared.domain.CustomerId;
import com.example.shared.domain.Isbn;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

public class SaleRepositoryMongoAdapter implements SaleRepository {

    private SaleDocumentRepository saleDocumentRepository;
    private ModelMapper mapper;
    public SaleRepositoryMongoAdapter(SaleDocumentRepository saleDocumentRepository) {
        this.saleDocumentRepository = saleDocumentRepository;
    }

    @Override
    public Boolean existBySaleId(SaleId saleId) {
        return saleDocumentRepository.existsById(saleId.getSaleId());
    }

    @Override
    public Optional<Sale> findBySaleId(SaleId saleId) {
        return Optional.empty();
    }

    @Override
    public List<Sale> listSales() {

        return null;
    }

    @Override
    public List<Sale> findSalesByPages(int page, int size) {
        return null;
    }

    @Override
    public List<Sale> findSalesByBookIsbn(Isbn isbn) {
        return null;
    }

    @Override
    public List<Sale> findByCustomerId(CustomerId customerId) {
        return null;
    }

    @Override
    public Sale saveSale(Sale sale) {
        var document = mapper.map(sale, SaleDocument.class);
        return mapper.map(saleDocumentRepository.save(document),Sale.class);
    }
}
