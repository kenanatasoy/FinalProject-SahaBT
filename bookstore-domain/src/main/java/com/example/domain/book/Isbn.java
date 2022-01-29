package com.example.domain.book;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Isbn {
    private final static Map<String, Isbn> cache = new HashMap<>();
    private final String value;

    private Isbn(String value) {
        this.value = value;
    }


    public static boolean isValid(String isbnn) {
        char[] isbn =isbnn.toCharArray();
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

}
