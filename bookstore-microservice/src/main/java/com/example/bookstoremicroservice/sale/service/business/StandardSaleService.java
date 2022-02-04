package com.example.bookstoremicroservice.sale.service.business;

import com.example.bookstoremicroservice.sale.dto.response.SaleResponse;
import com.example.sale.application.SaleApplication;
import com.example.bookstoremicroservice.sale.service.SaleService;
import com.example.sale.domain.SaleId;
import com.example.shared.domain.CustomerId;
import com.example.shared.domain.Isbn;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StandardSaleService implements SaleService {
    private SaleApplication saleApplication;
    private ModelMapper modelMapper;

    public StandardSaleService(SaleApplication saleApplication, ModelMapper modelMapper) {
        this.saleApplication = saleApplication;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SaleResponse> findSalesByPages(int page, int size)
    {
        var sales=saleApplication.findSalesByPages(page, size);
        return sales.stream().map((s) -> modelMapper.map(s,SaleResponse.class))
                .toList();
    }

    @Override
    public List<SaleResponse> getSalesByBookId(String bookId)
    {
        var sales=saleApplication.getSalesByBookId(Isbn.valueOf(bookId));

        return sales.stream().map((s) -> modelMapper.map(s,SaleResponse.class))
                .toList();

    }

    @Override
    public SaleResponse findBySaleId(int saleId) {
        var sale = saleApplication.getBySaleId(SaleId.valueOf(saleId));
        return modelMapper.map(sale,SaleResponse.class);
    }

    @Override
    public List<SaleResponse> getSalesByCustomerId(String customerId) {
        var sales=saleApplication.getByCustomerId(CustomerId.valueOf(customerId));

        return sales.stream().map((s) -> modelMapper.map(s,SaleResponse.class))
                .toList();
    }
}
