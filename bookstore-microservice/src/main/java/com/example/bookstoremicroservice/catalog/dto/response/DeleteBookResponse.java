package com.example.bookstoremicroservice.catalog.dto.response;

public class DeleteBookResponse {
    private String isbn;
    private String author;
    private String title;
    private String edition;


    public DeleteBookResponse() {
    }

    public String getIsbn() {
        return isbn;
    }

    public DeleteBookResponse setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public DeleteBookResponse setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public DeleteBookResponse setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getEdition() {
        return edition;
    }

    public DeleteBookResponse setEdition(String edition) {
        this.edition = edition;
        return this;
    }
}
