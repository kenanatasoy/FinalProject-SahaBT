package com.example.application.business.events;

import com.example.domain.book.Book;

public class BookDeletedEvent extends BookEvent {
    private  final Book book;

    public BookDeletedEvent(Book book) {
        this.book = book;
    }


    public Book getBook() {
        return book;
    }
}
