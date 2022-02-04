package com.example.application.business;

import com.example.application.CatalogApplication;
import com.example.application.CategoryApplication;
import com.example.application.business.events.BookAddedEvent;
import com.example.application.business.events.BookDeletedEvent;
import com.example.application.business.exception.BookNotFoundException;
import com.example.application.business.exception.ExistingBookException;

import com.example.application.business.exception.ExistingCategoryException;
import com.example.domain.book.Book;
import com.example.domain.category.Category;
import com.example.domain.category.CategoryId;
import com.example.infrastructure.CatalogEventPublisher;
import com.example.repository.CatalogRepository;
import com.example.repository.CategoryRepository;
import com.example.shared.domain.Isbn;

import java.util.List;
import java.util.Optional;

public class StandardCatalogApplication implements CatalogApplication, CategoryApplication {
    private final CatalogEventPublisher catalogEventPublisher;
    private final CatalogRepository catalogRepository;
    private final CategoryRepository categoryRepository;


    public StandardCatalogApplication(CatalogEventPublisher catalogEventPublisher, CatalogRepository catalogRepository, CategoryRepository categoryRepository) {
        this.catalogEventPublisher = catalogEventPublisher;
        this.catalogRepository = catalogRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Book addBook(Book book, int amount) {
        Isbn isbn = book.getIsbn();
        if (catalogRepository.existBookByIsbn(isbn))
            throw new ExistingBookException("Book already exist", isbn.getValue());
        Book addedBook = catalogRepository.save(book);
        var businessEvent = new BookAddedEvent(addedBook, amount);
        catalogEventPublisher.publishEvent(businessEvent);
        return addedBook;
    }

    @Override
    public Book deleteBook(Isbn isbn) {
        Optional<Book> deletedBook = catalogRepository.delete(isbn);
        var book = deletedBook.orElseThrow(() -> new BookNotFoundException("Book does not exist", isbn.getValue()));
        catalogEventPublisher.publishEvent(new BookDeletedEvent(book));
        return book;
    }

    @Override
    public Optional<Book> findBookByIsbn(Isbn isbn) {
        return catalogRepository.findByID(isbn);


    }

    @Override
    public List<Book> findByCategoryId(CategoryId categoryId) {
        return catalogRepository.findBooksByCategoryId(categoryId);

    }

    @Override
    public Category getCategoryById(CategoryId categoryId) {

        return categoryRepository.findCategoryById(categoryId).orElseThrow(()-> new IllegalArgumentException("Category Not found"));
    }

    @Override
    public Category addCategory(Category category) {
        CategoryId categoryId = category.getId();
        if (categoryRepository.existCategoryByCategoryId(categoryId))
            throw new ExistingCategoryException("Category already exist", categoryId.getCategoryId());
        Category addedCategory = categoryRepository.saveCategory(category);
        return addedCategory;
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.listCategories();
    }
}



