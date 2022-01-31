package com.example.application.business.exception;


@SuppressWarnings("serial")
public class ExistingBookException extends RuntimeException{
    private final String isbn;

    public ExistingBookException(String message ,String isbn) {
        super(message);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
