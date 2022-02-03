package com.example.customer.domain;

public final class Epurse {

    private final double value;

    private Epurse(double value) {
        this.value = value;
    }

    public static Epurse valueOf(double value) {
        if (value < 0)
            throw new IllegalArgumentException("Value must be bigger than 0");
        return new Epurse(value);
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Epurse{" +
                "value=" + value +
                '}';
    }
}
