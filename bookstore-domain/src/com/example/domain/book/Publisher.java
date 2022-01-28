package com.example.domain.book;

import java.util.Objects;

public final class Publisher {
    private final String first;
    private final String last;
    private Publisher(String first, String last) {
        this.first = first;
        this.last = last;
    }
    public static Publisher of(String first,String last) {
        Objects.requireNonNull(first);
        Objects.requireNonNull(last);
        if(first.length()<2||last.length()<2)
            throw  new IllegalArgumentException("Fullname should have at least two characters");
        return new Publisher(first, last);
    }
    public String getFirst() {
        return first;
    }
    public String getLast() {
        return last;
    }
    @Override
    public String toString() {
        return "Publisher [first=" + first + ", last=" + last + "]";
    }
}
