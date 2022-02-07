package com.example.bookstoremicroservice.catalog.service.business;

import com.example.application.CatalogApplication;
import com.example.application.business.exception.BookNotFoundException;
import com.example.bookstoremicroservice.catalog.document.BookDocument;
import com.example.bookstoremicroservice.catalog.dto.request.AddBookRequest;
import com.example.bookstoremicroservice.catalog.service.CatalogService;
import com.example.bookstoremicroservice.catalog.dto.response.AddedBookResponse;
import com.example.bookstoremicroservice.catalog.dto.response.DeleteBookResponse;
import com.example.bookstoremicroservice.catalog.dto.response.GetBookResponse;
import com.example.domain.book.Book;
import com.example.domain.category.CategoryId;
import com.example.shared.domain.Isbn;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.EventListener;
import java.util.List;

@Service
public class StandartCatalogService implements CatalogService {
  private CatalogApplication catalogApplication;
  private ModelMapper modelMapper;

    public StandartCatalogService(CatalogApplication catalogApplication, ModelMapper modelMapper) {
        this.catalogApplication = catalogApplication;
        this.modelMapper = modelMapper;
    }

    @Override
    public GetBookResponse findBooksByIsbn(String isbn) { //book to getBookResponse converter
        var book = catalogApplication.findBookByIsbn(Isbn.valueOf(isbn));
        if(book.isEmpty())
            throw  new BookNotFoundException("Cannot Find Book",isbn);
        return  modelMapper.map(book.get(),GetBookResponse.class);

    }

    @Override
    public AddedBookResponse addBook(AddBookRequest request,int amount) { //addedbook request to book - book to addedBook response
        var book = modelMapper.map(request, BookDocument.class);
        var addedBook=catalogApplication.addBook(book,amount);
        return null;
    }

    @Override
    public DeleteBookResponse deleteBook(String isbn) {//employe to deleted book converter
       var book=catalogApplication.deleteBook(Isbn.valueOf(isbn));
        return modelMapper.map(book,DeleteBookResponse.class);
    }

    @Override
    public List<GetBookResponse> findBooksByCategoryId(int categoryId) {
        List<Book> books =catalogApplication.findByCategoryId(CategoryId.valueOf(categoryId));
        return books.stream().map(book -> modelMapper.map(book,GetBookResponse.class)).toList();
    }
}
