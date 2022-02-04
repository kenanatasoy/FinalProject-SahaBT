package com.example.bookstoremicroservice.catalog.controller;

import com.example.bookstoremicroservice.catalog.dto.request.AddBookRequest;
import com.example.bookstoremicroservice.catalog.dto.response.AddedBookResponse;
import com.example.bookstoremicroservice.catalog.dto.response.DeleteBookResponse;
import com.example.bookstoremicroservice.catalog.dto.response.GetBookResponse;
import com.example.bookstoremicroservice.category.dto.response.GetCategoryResponse;
import com.example.bookstoremicroservice.catalog.service.CatalogService;
import com.example.bookstoremicroservice.category.service.CategoryService;
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
    public DeleteBookResponse deleteBook(@PathVariable String isbn){
       return catalogService.deleteBook(isbn);
    }

    @GetMapping ("{categoryId}")
    public GetCategoryResponse addCategory(@PathVariable int categoryId ){
        return categoryService.addCategory(categoryId);
    }

}
