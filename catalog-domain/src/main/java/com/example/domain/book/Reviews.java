package com.example.domain.book;

public final class Reviews {
    public final String value;

    public Reviews(String value) {
        this.value = value;
    }

    public static Reviews valueOf(String value) {
        return Reviews.valueOf(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "value=" + value +
                '}';
    }
}
