package com.example.domain.book;

public final class PublicationYear {
    private final int value;

    public PublicationYear(int value) {
        this.value = value;

    }

    public static PublicationYear valueOf(int value) {
        return PublicationYear.valueOf(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PublicationYear{" +
                "value=" + value +
                '}';
    }
}
