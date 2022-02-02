package com.example.customer.domain;

public final class Age {

    private final int value;

    private Age(int value) {
        this.value = value;
    }

    public static Age valueOf(int value) {
        if (value < 12)
            throw new IllegalArgumentException("Customers age should be larger than 12");
        return new Age(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Age{" +
                "value=" + value +
                '}';
    }
}
