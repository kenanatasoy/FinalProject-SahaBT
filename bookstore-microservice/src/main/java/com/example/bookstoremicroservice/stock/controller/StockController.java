package com.example.bookstoremicroservice.stock.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import io.swagger.annotations.Api;

@RestController
@RequestScope
@RequestMapping("stocks")
@CrossOrigin
@Validated
@Api( tags = "Stocks")
public class StockController {

}

