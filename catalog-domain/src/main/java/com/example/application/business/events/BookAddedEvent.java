package com.example.application.business.events;

import com.example.domain.book.Book;

public class BookAddedEvent extends BookEvent {
    private final Book book;
    private final int amount;

    public BookAddedEvent(Book book, int amount) {
        this.book = book;
        this.amount = amount;
    }

    public Book getBook() {
        return book;
    }

    public int getAmount() {
        return amount;
    }
}
