package com.example.domain.book;

public final class Author {
    private final String value;

    public Author(String value) {
        this.value = value;
    }
    public  static  Author valueOf(String value){
        return Author.valueOf(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Author{" +
                "value='" + value + '\'' +
                '}';
    }
}

