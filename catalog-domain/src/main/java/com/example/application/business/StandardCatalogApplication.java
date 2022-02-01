package com.example.application.business;

import com.example.application.CatalogApplication;
import com.example.application.business.events.BookAddedEvent;
import com.example.application.business.events.BookDeletedEvent;
import com.example.application.business.exception.BookNotFoundException;
import com.example.application.business.exception.ExistingBookException;
import com.example.category.domain.Category;
import com.example.category.domain.CategoryId;
import com.example.category.domain.SubCategory;
import com.example.domain.book.Book;
import com.example.infrastructure.EventPublisher;
import com.example.repository.CatalogRepository;

import java.util.List;
import java.util.Optional;

public class StandardCatalogApplication implements CatalogApplication {
    private final EventPublisher eventPublisher;
    private final CatalogRepository catalogRepository;

    public StandardCatalogApplication(EventPublisher eventPublisher, CatalogRepository catalogRepository) {
        this.eventPublisher = eventPublisher;
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Book addBook(Book book) {
        var isbn = book.getIsbn();
        if (catalogRepository.existByIsbn(isbn))
            throw new ExistingBookException("Book already exist", isbn.getValue());
        Book addedBook = catalogRepository.save(book);
        var businessEvent = new BookAddedEvent(addedBook);
        eventPublisher.publishEvent(businessEvent);
        return addedBook;
    }

    @Override
    public Book deleteBook(Isbn isbn) {
        Optional<Book> deletedBook=catalogRepository.delete(isbn);
        var book= deletedBook.orElseThrow(()->new BookNotFoundException("Book does not exist",isbn.getValue()));
        eventPublisher.publishEvent(new BookDeletedEvent(book));
        return null;
    }

    @Override
    public Optional<Book> findBookByIsbn(Isbn isbn) {
        return Optional.empty();
    }

    @Override
    public List<Book> findByCategoryId(CategoryId categoryId) {

        return null;
    }

    @Override
    public Category getCategoryById(CategoryId categoryId) {
        return null;
    }

    @Override
    public Category addCategory(Category category) {
        return null;
    }

    @Override
    public SubCategory addSubCategory(Category subCategory) {
        return null;
    }

    @Override
    public List<Category> listCategories() {
        return null;
    }

    @Override
    public List<SubCategory> listSubCategories() {
        return null;
    }

    @Override
    public List<SubCategory> listSubCategoriesByCategoryId(CategoryId categoryId) {
        return null;
    }
}



