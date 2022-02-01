package com.example.domain.book;

public final class Reviews {
    public final double value;

    public Reviews(double value) {
        this.value = value;
    }

    public static Reviews valueOf(double value) {
        return Reviews.valueOf(value);
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "value=" + value +
                '}';
    }
}
