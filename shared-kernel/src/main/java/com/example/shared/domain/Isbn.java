package com.example.shared.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Isbn {

    private final static Map<String, Isbn> cache = new HashMap<>();
    private final String value;

    private Isbn(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }



    public static boolean isValid(String value) {
        char[] isbn =value.toCharArray();
        int sum = 0;
        if(isbn.length == 10) {
            for(int i = 0; i < 10; i++) {
                sum += i * isbn[i]; //asuming this is 0..9, not '0'..'9'
            }

            if(isbn[9] == sum % 11) return true;
        } else if(isbn.length == 13) {

            for(int i = 0; i < 12; i++) {
                if(i % 2 == 0) {
                    sum += isbn[i]; //asuming this is 0..9, not '0'..'9'
                } else {
                    sum += isbn[i] * 3;
                }
            }

            if(isbn[12] == 10 - (sum % 10)) return true;
        }

        return false;
    }

    public static Isbn valueOf(String value) {
        if (!isValid(value))
            throw new IllegalArgumentException("This is not a valid identity no!");
        var isbn = cache.get(value);
        if (Objects.isNull(isbn)) {
            isbn = new Isbn(value);
            cache.put(value, isbn);
        }
        return isbn;
    }


    @Override
    public String toString() {
        return "Isbn{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Isbn isbn = (Isbn) o;
        return value.equals(isbn.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
