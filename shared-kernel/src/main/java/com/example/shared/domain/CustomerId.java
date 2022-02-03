package com.example.shared.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class CustomerId {

    private final static Map<String, CustomerId> cache = new HashMap<>();
    private final String value;

    private CustomerId(String value) {
        this.value = value;
    }

    public static CustomerId valueOf(String value) {
        var identity = cache.get(value);
        if (Objects.isNull(identity)) {
            identity = new CustomerId(value);
            cache.put(value, identity);
        }
        return identity;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CustomerId other = (CustomerId) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "Identity{" +
                "value='" + value + '\'' +
                '}';
    }
}