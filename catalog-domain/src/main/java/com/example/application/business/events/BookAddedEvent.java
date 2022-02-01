package com.example.application.business.events;

import com.example.domain.book.Book;

public class BookAddedEvent extends BookEvent {
    private  final Book book;

    public BookAddedEvent(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}
