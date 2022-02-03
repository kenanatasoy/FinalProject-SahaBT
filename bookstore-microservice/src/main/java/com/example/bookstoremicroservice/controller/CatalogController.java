package com.example.bookstoremicroservice.controller;

import com.example.bookstoremicroservice.controller.dto.request.AddBookRequest;
import com.example.bookstoremicroservice.dto.response.AddedBookResponse;
import com.example.bookstoremicroservice.dto.response.DeletetBookResponse;
import com.example.bookstoremicroservice.dto.response.GetBookResponse;
import com.example.bookstoremicroservice.dto.response.GetCategoryResponse;
import com.example.bookstoremicroservice.service.CatalogService;
import com.example.bookstoremicroservice.service.CategoryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
@RequestMapping("catalog")
@CrossOrigin

public class CatalogController {
   private CatalogService catalogService;
   private CategoryService categoryService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("{isbn}")
    public GetBookResponse getBookByIsbn(@PathVariable String isbn){
        return catalogService.findEmployeeByIdentity(isbn);
    }
    @PostMapping
    public AddedBookResponse addBook(@RequestBody AddBookRequest request){
       return catalogService.addBook(request);
    }
    @DeleteMapping({"isbn"})
    public DeletetBookResponse deleteBook(@PathVariable String isbn){
       return catalogService.deleteBook(isbn);
    }

    @GetMapping ("{categoryId}")
    public GetCategoryResponse addCategory(@PathVariable int categoryId ){
        return categoryService.addCategory(categoryId);
    }

}
