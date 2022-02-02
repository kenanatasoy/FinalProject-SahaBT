package com.example.service;

import com.example.controller.dto.request.AddBookRequest;
import com.example.dto.response.AddedBookResponse;
import com.example.dto.response.DeletetBookResponse;
import com.example.dto.response.GetBookResponse;

public interface CatalogService {
    GetBookResponse findEmployeeByIdentity(String isbn);

    AddedBookResponse addBook(AddBookRequest request);

    DeletetBookResponse deleteBook(String isbn);
}
