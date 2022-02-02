package com.example.customer.domain;

public final class Location {

    private final String value;

    private Location(String value) {
        this.value = value;
    }

    public static Location valueOf(String value) {
        return new Location(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Location{" +
                "value='" + value + '\'' +
                '}';
    }
}
