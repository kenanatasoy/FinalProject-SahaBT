package com.example.domain.book;

public final class Popularity {
    private final String value;

    public Popularity(String value) {
        this.value = value;
    }

    public static Popularity valueOf(String value) {
        return Popularity.valueOf(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Popularity{" +
                "value='" + value + '\'' +
                '}';
    }
}
