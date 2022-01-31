package com.example.domain.book;

public final class Contents {
    private final String value;

    private Contents(String value) {
        this.value = value;
    }

    public static Contents valueOf(String value) {
        return Contents.valueOf(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Contents{" +
                "value='" + value + '\'' +
                '}';
    }
}
