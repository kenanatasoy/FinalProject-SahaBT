package com.example.bookstoremicroservice.service;

import com.example.bookstoremicroservice.controller.dto.request.AddBookRequest;
import com.example.bookstoremicroservice.dto.response.AddedBookResponse;
import com.example.bookstoremicroservice.dto.response.DeletetBookResponse;
import com.example.bookstoremicroservice.dto.response.GetBookResponse;

public interface CatalogService {
    GetBookResponse findEmployeeByIdentity(String isbn);

    AddedBookResponse addBook(AddBookRequest request);

    DeletetBookResponse deleteBook(String isbn);
}
