package com.example.bookstoremicroservice.catalog.modelMapperConverters;

import com.example.bookstoremicroservice.catalog.document.BookDocument;
import com.example.domain.book.Book;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookConverters {
    public  static final Converter<BookDocument, Book>
            BOOK_DOCUMENT_TO_BOOK_CONVERTER= context -> {
        var document =context.getSource();
        return new Book.Builder()
                .isbn(document.getIsbn())
                .author(document.getAuthor())
                .title(document.getTitle())
                .contents(document.getContents())
                .coverPhoto(document.getCoverPhoto().getBytes())
                .popularity(document.getPopularty())
                .price(document.getPrice())
                .publicationYear(document.getPublicationYear())
                .reviews(document.getReview())
                .edition(document.getEdition())
                .categoryId(document.getCategoryId())
                .publisherId(document.getPublisherId())
                .build();
    };

}
