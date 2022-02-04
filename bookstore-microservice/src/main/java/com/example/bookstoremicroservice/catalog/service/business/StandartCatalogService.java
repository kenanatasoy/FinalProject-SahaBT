package com.example.bookstoremicroservice.catalog.service.business;

import com.example.bookstoremicroservice.catalog.dto.request.AddBookRequest;
import com.example.bookstoremicroservice.catalog.service.CatalogService;
import com.example.bookstoremicroservice.catalog.dto.response.AddedBookResponse;
import com.example.bookstoremicroservice.catalog.dto.response.DeleteBookResponse;
import com.example.bookstoremicroservice.catalog.dto.response.GetBookResponse;
import org.springframework.stereotype.Service;

@Service
public class StandartCatalogService implements CatalogService {
    @Override
    public GetBookResponse findEmployeeByIdentity(String isbn) {
        return null;
    }

    @Override
    public AddedBookResponse addBook(AddBookRequest request) {
        return null;
    }

    @Override
    public DeleteBookResponse deleteBook(String isbn) {
        return null;
    }
}
