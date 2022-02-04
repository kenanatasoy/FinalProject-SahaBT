package com.example.bookstoremicroservice.catalog.controller;

import com.example.bookstoremicroservice.catalog.dto.request.AddBookRequest;
import com.example.bookstoremicroservice.catalog.dto.response.AddedBookResponse;
import com.example.bookstoremicroservice.catalog.dto.response.DeleteBookResponse;
import com.example.bookstoremicroservice.catalog.dto.response.GetBookResponse;
import com.example.bookstoremicroservice.category.dto.response.GetCategoryResponse;
import com.example.bookstoremicroservice.catalog.service.CatalogService;
import com.example.bookstoremicroservice.category.service.CategoryService;
import com.example.controller.dto.request.AddCategoryRequest;
import com.example.dto.response.AddedCategoryResponse;
import com.example.dto.response.DeleteCategoryResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

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
        return catalogService.findBooksByIsbn(isbn);
    }
    @GetMapping("/books")
    public List<GetBookResponse> getBooksByCategoryId(@RequestParam int categoryId){
        return catalogService.findBooksByCategoryId(categoryId);
    }
    @PostMapping
    public AddedBookResponse addBook(@RequestBody AddBookRequest request){
       return catalogService.addBook(request);
    }
    @DeleteMapping({"isbn"})
    public DeleteBookResponse deleteBook(@PathVariable String isbn){
       return catalogService.deleteBook(isbn);
    }

    @PostMapping("{category}")
    public AddedCategoryResponse addCategory(@RequestBody AddCategoryRequest request ){
        return categoryService.addCategory(request);
    }
    @GetMapping("{categoryId}")
    public



}
