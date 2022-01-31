package com.example.domain.book;

public final class Edition {
    private final String value;

   private Edition(String value) {
        this.value = value;
    }

    public static Edition valueOf(String value) {
       return Edition.valueOf(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "value='" + value + '\'' +
                '}';
    }
}
