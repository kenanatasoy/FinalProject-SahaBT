package com.example.bookstoremicroservice.sale.controller;

import com.example.bookstoremicroservice.sale.dto.request.MakeSaleRequest;
import com.example.bookstoremicroservice.sale.dto.response.MakeSaleResponse;
import com.example.bookstoremicroservice.sale.dto.response.SaleResponse;
import com.example.bookstoremicroservice.sale.service.SaleService;
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

    private final SaleService saleService;

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

    @GetMapping("{saleId}")
    public SaleResponse getBySaleId(@PathVariable int saleId)
    {
        return saleService.findBySaleId(saleId);
    }

    @GetMapping("{customerId}")
    public List<SaleResponse> getSalesByCustomerId(@PathVariable  String customerId){

        return saleService.getSalesByCustomerId(customerId);
    }

    @PostMapping
    public MakeSaleResponse makeSale(
            @RequestBody MakeSaleRequest sale, int amount){

        return saleService.makeSale(sale,amount);
    }



}
