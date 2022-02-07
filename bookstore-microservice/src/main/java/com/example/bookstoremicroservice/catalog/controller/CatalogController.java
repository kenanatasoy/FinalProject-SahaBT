package com.example.bookstoremicroservice.catalog.controller;

import com.example.bookstoremicroservice.catalog.dto.request.AddBookRequest;
import com.example.bookstoremicroservice.catalog.dto.response.AddedBookResponse;
import com.example.bookstoremicroservice.catalog.dto.response.DeleteBookResponse;
import com.example.bookstoremicroservice.catalog.dto.response.GetBookResponse;
import com.example.bookstoremicroservice.category.dto.response.CategoryResponse;
import com.example.bookstoremicroservice.catalog.service.CatalogService;
import com.example.bookstoremicroservice.category.service.CategoryService;
import com.example.bookstoremicroservice.category.dto.request.AddCategoryRequest;
import com.example.bookstoremicroservice.category.dto.response.AddedCategoryResponse;
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
    @PostMapping("addbook")
    public AddedBookResponse addBook(@RequestBody AddBookRequest request,int amount){
       return catalogService.addBook(request,amount);
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
    public CategoryResponse getCategory (@PathVariable int categoryId){
        return categoryService.getCategoryByCategoryId(categoryId);
    }
    @GetMapping("{categorys}}")
    public  List<CategoryResponse> getAllCategories (){
        return categoryService.getAllCatagories();
    }




}
