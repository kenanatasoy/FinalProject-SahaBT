package com.example.bookstoremicroservice.catalog.service;

import com.example.bookstoremicroservice.catalog.dto.request.AddBookRequest;
import com.example.bookstoremicroservice.catalog.dto.response.AddedBookResponse;
import com.example.bookstoremicroservice.catalog.dto.response.DeleteBookResponse;
import com.example.bookstoremicroservice.catalog.dto.response.GetBookResponse;

public interface CatalogService {
    GetBookResponse findEmployeeByIdentity(String isbn);

    AddedBookResponse addBook(AddBookRequest request);

    DeleteBookResponse deleteBook(String isbn);
}
