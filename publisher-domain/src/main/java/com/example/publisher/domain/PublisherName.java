package com.example.publisher.domain;

import java.util.Objects;

public class PublisherName {
    private final String first;
    private final String last;

    private PublisherName(String first, String last) {
        this.first = first;
        this.last = last;
    }
    public static PublisherName of(String first, String last){
        Objects.requireNonNull(first);
        Objects.requireNonNull(last);
        if (first.length() < 3 || last.length() < 3)
            throw new IllegalArgumentException("Publisher Name should have at least three characters");
        return new PublisherName(first, last);
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    @Override
    public String toString() {
        return "PublisherName{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
