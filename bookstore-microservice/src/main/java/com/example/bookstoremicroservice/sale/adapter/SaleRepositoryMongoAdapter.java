package com.example.bookstoremicroservice.sale.adapter;

import com.example.bookstoremicroservice.sale.document.SaleDocument;
import com.example.bookstoremicroservice.sale.repository.SaleDocumentMongoRepository;
import com.example.sale.domain.Sale;
import com.example.sale.domain.SaleId;
import com.example.sale.repository.SaleRepository;
import com.example.shared.domain.CustomerId;
import com.example.shared.domain.Isbn;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SaleRepositoryMongoAdapter implements SaleRepository {

    private final SaleDocumentMongoRepository saleDocumentRepository;
    private final ModelMapper mapper;
    public SaleRepositoryMongoAdapter(SaleDocumentMongoRepository saleDocumentRepository, ModelMapper mapper) {
        this.saleDocumentRepository = saleDocumentRepository;
        this.mapper = mapper;
    }

    @Override
    public Boolean existBySaleId(SaleId saleId) {
        return saleDocumentRepository.existsById(saleId.getSaleId());
    }

    @Override
    public Optional<Sale> findBySaleId(SaleId saleId) {
        return saleDocumentRepository.findById(saleId.getSaleId())
                .map(doc -> mapper.map(doc, Sale.class));
    }

    @Override
    public List<Sale> listSales() {

        var saleDocuments = saleDocumentRepository.findAll();

       return saleDocuments.stream()
               .map((sd) -> mapper.map(sd,Sale.class))
               .toList();
    }

    @Override
    public List<Sale> findSalesByPages(int page, int size) {
        var pageRequest = PageRequest.of(page, size);
        return saleDocumentRepository.findAll(pageRequest).stream().map(emp -> mapper.map(emp, Sale.class))
                .toList();
    }

    @Override
    public List<Sale> findSalesByBookIsbn(Isbn isbn) {
        return saleDocumentRepository.findByBookId(isbn.getValue());
    }

    @Override
    public List<Sale> findSalesByCustomerId(CustomerId customerId) {
        return saleDocumentRepository.findByCustomerId(customerId.getValue());
    }

    @Override
    public Sale saveSale(Sale sale) {
        var document = mapper.map(sale, SaleDocument.class);
        return mapper.map(saleDocumentRepository.save(document),Sale.class);
    }
}
