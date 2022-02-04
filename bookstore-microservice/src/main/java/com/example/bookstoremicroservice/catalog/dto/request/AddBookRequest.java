package com.example.bookstoremicroservice.catalog.dto.request;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class AddBookRequest {
    private String isbn;
    private String author;
    private String title;
    private String contents;
    private byte[] coverPhoto;
    private String edition;
    private String popularty;
    private double price;
    private int publicationYear;
    private String review;
    private String categoryId;
    private String publisherId;

    public AddBookRequest() {
    }

    public String getIsbn() {
        return isbn;
    }

    public AddBookRequest setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public AddBookRequest setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AddBookRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContents() {
        return contents;
    }

    public AddBookRequest setContents(String contents) {
        this.contents = contents;
        return this;
    }

    public byte[] getCoverPhoto() {
        return coverPhoto;
    }

    public AddBookRequest setCoverPhoto(byte[] coverPhoto) {
        this.coverPhoto = coverPhoto;
        return this;
    }

    public String getEdition() {
        return edition;
    }

    public AddBookRequest setEdition(String edition) {
        this.edition = edition;
        return this;
    }

    public String getPopularty() {
        return popularty;
    }

    public AddBookRequest setPopularty(String popularty) {
        this.popularty = popularty;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public AddBookRequest setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public AddBookRequest setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
        return this;
    }

    public String getReview() {
        return review;
    }

    public AddBookRequest setReview(String review) {
        this.review = review;
        return this;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public AddBookRequest setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public AddBookRequest setPublisherId(String publisherId) {
        this.publisherId = publisherId;
        return this;
    }

    @Override
    public String toString() {
        return "AddBookRequest{" +
                "isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", edition='" + edition + '\'' +
                ", popularty='" + popularty + '\'' +
                ", price=" + price +
                ", publicationYear=" + publicationYear +
                ", review='" + review + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", publisherId='" + publisherId + '\'' +
                '}';
    }
}
