package com.example.bookstoremicroservice.catalog.adapter;

import com.example.bookstoremicroservice.catalog.document.BookDocument;
import com.example.bookstoremicroservice.catalog.repository.BookDocumentMongoRepository;
import com.example.domain.book.Book;
import com.example.domain.category.CategoryId;
import com.example.repository.CatalogRepository;
import com.example.shared.domain.Isbn;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CatalogRepositoryMongoAdapter implements CatalogRepository {
    private BookDocumentMongoRepository bookDocumentMongoRepository;
    private ModelMapper modelMapper;

    public CatalogRepositoryMongoAdapter(BookDocumentMongoRepository bookDocumentMongoRepository, ModelMapper modelMapper) {
        this.bookDocumentMongoRepository = bookDocumentMongoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean existBookByIsbn(Isbn isbn) {
        return bookDocumentMongoRepository.existsById(isbn.getValue());
    }

    @Override
    public Book save(Book book) {
        var document= modelMapper.map(book, BookDocument.class);

        return modelMapper.map(bookDocumentMongoRepository.save(document),Book.class);
    }

    @Override
    public Optional<Book> delete(Isbn isbn) {
       var document=bookDocumentMongoRepository.findById(isbn.getValue());
       document.ifPresent(bookDocumentMongoRepository::delete);

        return document.map(doc->modelMapper.map(doc,Book.class));
    }

    @Override
    public Optional<Book> findByID(Isbn isbn) {
        return bookDocumentMongoRepository.findById(isbn.getValue()).map(doc->modelMapper.map(doc,Book.class));
    }

    @Override
    public List<Book> findBooksByCategoryId(CategoryId categoryId) {
        var searchedCategory=categoryId.getCategoryId();
        List<BookDocument> documents= bookDocumentMongoRepository.findAllByCategoryId(searchedCategory);
        List<Book> books= documents.stream().map(doc->modelMapper.map(doc,Book.class)).toList();
        return  books;
    }
}
