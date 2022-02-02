package com.example.customer.domain;

public class Username {
    private final String value;

    private Username(String value) {
        this.value = value;
    }

    public static Username valueOf(String value) {
        if (value.length() < 3 || value.length() > 8)
            throw new IllegalArgumentException("Value length must be between 3 and 8 characters");
        return new Username(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Username{" +
                "value='" + value + '\'' +
                '}';
    }
}

