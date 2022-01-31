package com.example.domain.book;

public final class Price {
    private final double value;

    public Price(double value) {
        this.value = value;
    }

    public static Price valueOf(double value) {
        if(value<=0.0)
            throw new IllegalArgumentException("Price cannot be zero or negative");
        return new Price(value);
    }


    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                '}';
    }
}
