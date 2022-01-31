package com.example.application.business;

import com.example.application.BookApplication;
import com.example.application.business.events.BookAddedEvent;
import com.example.application.business.exception.ExistingBookException;
import com.example.domain.book.Author;
import com.example.domain.book.Book;
import com.example.domain.book.Isbn;
import com.example.domain.book.Title;
import com.example.infrastructure.EventPublisher;
import com.example.repository.BookRepository;

import java.util.List;
import java.util.Optional;

public class StandardBookApplication implements BookApplication {
    private EventPublisher eventPublisher;
    private BookRepository bookRepository;

    public StandardBookApplication(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Book addBook(Book book) {
        var isbn = book.getIsbn();
        if(bookRepository.existByIsbn(isbn))
            throw new ExistingBookException("Book already exist",isbn.getValue());
        Book addedBook = bookRepository.save(book);
        var businessEvent =new BookAddedEvent(addedBook);
        eventPublisher.publishEvent(businessEvent);
        return addedBook;
    }

    @Override
    public Book deleteBook(Isbn isbn) {
        return null;
    }

    @Override
    public Optional<Book> findBookByIsbn(Isbn isbn) {
        return Optional.empty();
    }
    public List<Book> findByAuthor(Author author) {

    }

    @Override
    public List<Book> findByTitle(Title title) {
        return null;
    }

}
