package com.example.bookstoremicroservice.controller;

import com.example.bookstoremicroservice.dto.response.SaleResponse;
import com.example.bookstoremicroservice.service.SaleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestScope
@RequestMapping("sale")
@CrossOrigin
public class SaleController {

    private SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public List<SaleResponse> getSales(@RequestParam @Min(0) int page, @RequestParam @Max(25) int size) {
        return saleService.findSalesByPages(page, size);
    }


    @GetMapping("{bookId}")
    public List<SaleResponse> getSalesByBookId(@PathVariable  String bookId){

        return saleService.getSalesByBookId(bookId);
    }

    @GetMapping("{saleId")
    public SaleResponse getBySaleId(@PathVariable int saleId)
    {
        return saleService.findBySaleId(saleId);
    }

    @GetMapping("{customerId}")
    public List<SaleResponse> getSalesByCustomerId(@PathVariable  String customerId){

        return saleService.getSalesByCustomerId(customerId);
    }



}
