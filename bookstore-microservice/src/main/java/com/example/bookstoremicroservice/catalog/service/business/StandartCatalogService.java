package com.example.bookstoremicroservice.catalog.service.business;

import com.example.application.CatalogApplication;
import com.example.application.business.exception.BookNotFoundException;
import com.example.bookstoremicroservice.catalog.document.BookDocument;
import com.example.bookstoremicroservice.catalog.dto.request.AddBookRequest;
import com.example.bookstoremicroservice.catalog.service.CatalogService;
import com.example.bookstoremicroservice.catalog.dto.response.AddedBookResponse;
import com.example.bookstoremicroservice.catalog.dto.response.DeleteBookResponse;
import com.example.bookstoremicroservice.catalog.dto.response.GetBookResponse;
import com.example.shared.domain.Isbn;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StandartCatalogService implements CatalogService {
  private CatalogApplication catalogApplication;
  private ModelMapper modelMapper;

    public StandartCatalogService(CatalogApplication catalogApplication, ModelMapper modelMapper) {
        this.catalogApplication = catalogApplication;
        this.modelMapper = modelMapper;
    }

    @Override
    public GetBookResponse findBooksByIsbn(String isbn) {
        var book = catalogApplication.findBookByIsbn(Isbn.valueOf(isbn));
        if(book.isEmpty())
            throw  new BookNotFoundException("Cannot Find Book",isbn);
        return  modelMapper.map(book.get(),GetBookResponse.class);

    }

    @Override
    public AddedBookResponse addBook(AddBookRequest request) {
        var book = modelMapper.map(request, BookDocument.class);
        return null;
    }

    @Override
    public DeleteBookResponse deleteBook(String isbn) {
        return null;
    }
}
