package com.example.bookstoremicroservice.catalog.dto.response;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class GetBookResponse {
    private String isbn;
    private String author;
    private String title;
    private String contents;
    private String popularty;
    private double price;
    private String review;
    private String categoryId;
    private String coverPhoto;


    public GetBookResponse() {
    }

    public String getIsbn() {
        return isbn;
    }

    public GetBookResponse setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public GetBookResponse setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public GetBookResponse setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContents() {
        return contents;
    }

    public GetBookResponse setContents(String contents) {
        this.contents = contents;
        return this;
    }

    public String getPopularty() {
        return popularty;
    }

    public GetBookResponse setPopularty(String popularty) {
        this.popularty = popularty;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public GetBookResponse setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getReview() {
        return review;
    }

    public GetBookResponse setReview(String review) {
        this.review = review;
        return this;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public GetBookResponse setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public GetBookResponse setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
        return this;
    }

    @Override
    public String toString() {
        return "GetBookResponse{" +
                "isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", popularty='" + popularty + '\'' +
                ", price=" + price +
                ", review='" + review + '\'' +
                ", categoryId='" + categoryId + '\'' +
                '}';
    }
}
