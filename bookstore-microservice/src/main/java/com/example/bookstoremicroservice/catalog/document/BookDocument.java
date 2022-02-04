package com.example.bookstoremicroservice.catalog.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "book")
public class BookDocument {
    @Id
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
    @DBRef(db="category")
    private String categoryId;
    @DBRef(db="publisher")
    private String publisherId;

    public BookDocument() {
    }

    public String getIsbn() {
        return isbn;
    }

    public BookDocument setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookDocument setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookDocument setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContents() {
        return contents;
    }

    public BookDocument setContents(String contents) {
        this.contents = contents;
        return this;
    }

    public byte[] getCoverPhoto() {
        return coverPhoto;
    }

    public BookDocument setCoverPhoto(byte[] coverPhoto) {
        this.coverPhoto = coverPhoto;
        return this;
    }

    public String getEdition() {
        return edition;
    }

    public BookDocument setEdition(String edition) {
        this.edition = edition;
        return this;
    }

    public String getPopularty() {
        return popularty;
    }

    public BookDocument setPopularty(String popularty) {
        this.popularty = popularty;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public BookDocument setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public BookDocument setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
        return this;
    }

    public String getReview() {
        return review;
    }

    public BookDocument setReview(String review) {
        this.review = review;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public BookDocument setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public BookDocument setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDocument that = (BookDocument) o;
        return isbn.equals(that.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "BookDocument{" +
                "isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", edition='" + edition + '\'' +
                ", popularty='" + popularty + '\'' +
                ", price=" + price +
                ", publicationYear=" + publicationYear +
                ", review='" + review + '\'' +
                ", category='" + category + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
