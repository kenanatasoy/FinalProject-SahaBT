package com.example.bookstoremicroservice.catalog.service;

import com.example.bookstoremicroservice.catalog.dto.request.AddBookRequest;
import com.example.bookstoremicroservice.catalog.dto.response.AddedBookResponse;
import com.example.bookstoremicroservice.catalog.dto.response.DeleteBookResponse;
import com.example.bookstoremicroservice.catalog.dto.response.GetBookResponse;

import java.util.List;

public interface CatalogService {
    GetBookResponse findBooksByIsbn(String isbn);

    AddedBookResponse addBook(AddBookRequest request,int amount);

    DeleteBookResponse deleteBook(String isbn);

    List<GetBookResponse> findBooksByCategoryId(int categoryId);
}
