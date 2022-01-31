package com.example.domain.book;

import java.util.Base64;
import java.util.Objects;

public final class CoverPhoto {
    private final byte[] values;

    public CoverPhoto(byte[] values) {
        this.values = values;
    }
    public static CoverPhoto valueOf(byte [] values) {
        Objects.requireNonNull(values);
        return new CoverPhoto(values);
    }
    public static CoverPhoto valueOf(String values) {
        Objects.requireNonNull(values);
        return new CoverPhoto(Base64.getDecoder().decode(values));
    }

    public byte[] getValues() {
        return values;
    }
    public String getBase64Values() {
        return String.valueOf(Base64.getEncoder().encode(values));
    }

}
