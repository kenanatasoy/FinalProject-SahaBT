package com.example.application.business.exception;

public class BookNotFoundException extends RuntimeException {
        private final String  isbn;


    public BookNotFoundException(String message,String isbn) {
        super(message);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}

