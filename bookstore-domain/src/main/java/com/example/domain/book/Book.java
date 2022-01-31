package com.example.domain.book;


import com.example.domain.Category;

import java.util.Objects;

public class Book {

    private Isbn isbn;
    private Title title;
    private Author author;
    private Publisher publisher;
    private Edition edition;
    private PublicationYear publicationYear;
    private Price price;
    private Reviews reviews;
    private Contents contents;
    private CoverPhoto coverPhoto;
    private Popularity popularity;
    private Category category;

    public static class Builder {

        private Isbn isbn;
        private Title title;
        private Author author;
        private Publisher publisher;
        private Edition edition;
        private PublicationYear publicationYear;
        private Price price;
        private Reviews reviews;
        private Contents contents;
        private CoverPhoto coverPhoto;
        private Popularity popularity;
        private Category category;

        public Builder isbn(String value) {
            this.isbn = Isbn.valueOf(value);
            return this;
        }

        public Builder title(String value) {
            this.title = Title.valueOf(value);
            return this;
        }

        public Builder author(String value) {
            this.author = Author.valueOf(value);
            return this;
        }

        public Builder publisher(String first, String last) {
            this.publisher = Publisher.valueOf(first, last);
            return this;
        }

        public Builder edition(String value) {
            this.edition = Edition.valueOf(value);
            return this;
        }

        public Builder publicationYear(int value) {
            this.publicationYear = PublicationYear.valueOf(value);
            return this;
        }

        public Builder price(double value) {
            this.price = Price.valueOf(value);
            return this;
        }

        public Builder reviews(double value) {
            this.reviews = Reviews.valueOf(value);
            return this;
        }

        public Builder contents(String value) {
            this.contents = Contents.valueOf(value);
            return this;
        }

        public Builder coverPhoto(String value) {
            this.coverPhoto = CoverPhoto.valueOf(value);
            return this;
        }

        public Builder popularity(String value) {
            this.popularity = Popularity.valueOf(value);
            return this;
        }

        public Builder category(String value) {
            this.category = Category.valueOf(value);
            return this;
        }


        public Book build(){
            var book =new Book(this.isbn);
            book.setAuthor(author);
            book.setCategory(category);
            book.setContents(contents);
            book.setEdition(edition);
            book.setCoverPhoto(coverPhoto);
            book.setPopularity(popularity);
            book.setPublicationYear(publicationYear);
            book.setReviews(reviews);
            book.setTitle(title);
            book.setPrice(price);
            book.setPublisher(publisher);
            return book;

        }


    }


    public Book(Isbn isbn) {
        this.isbn = isbn;
    }

    public Title getTitle() {
        return title;
    }

    public Book setTitle(Title title) {
        this.title = title;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Book setPublisher(Publisher publisher) {
        this.publisher = publisher;
        return this;
    }

    public Edition getEdition() {
        return edition;
    }

    public Book setEdition(Edition edition) {
        this.edition = edition;
        return this;
    }

    public PublicationYear getPublicationYear() {
        return publicationYear;
    }

    public Book setPublicationYear(PublicationYear publicationYear) {
        this.publicationYear = publicationYear;
        return this;
    }

    public Price getPrice() {
        return price;
    }

    public Book setPrice(Price price) {
        this.price = price;
        return this;
    }

    public Reviews getReviews() {
        return reviews;
    }

    public Book setReviews(Reviews reviews) {
        this.reviews = reviews;
        return this;
    }

    public Contents getContents() {
        return contents;
    }

    public Book setContents(Contents contents) {
        this.contents = contents;
        return this;
    }

    public CoverPhoto getCoverPhoto() {
        return coverPhoto;
    }

    public Book setCoverPhoto(CoverPhoto coverPhoto) {
        this.coverPhoto = coverPhoto;
        return this;
    }

    public Popularity getPopularity() {
        return popularity;
    }

    public Book setPopularity(Popularity popularity) {
        this.popularity = popularity;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Book setCategory(Category category) {
        this.category = category;
        return this;
    }

    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return isbn.equals(builder.isbn);
        }

        @Override
        public int hashCode() {
            return Objects.hash(isbn);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "isbn=" + isbn +
                    ", title=" + title +
                    ", author=" + author +
                    ", publisher=" + publisher +
                    ", edition=" + edition +
                    ", publicationYear=" + publicationYear +
                    ", price=" + price +
                    ", reviews=" + reviews +
                    ", contents=" + contents +
                    ", popularity=" + popularity +
                    ", reviews=" + reviews +
                    ", category=" + category +
                    '}';
        }

}

