package com.example.domain.book;

public final class Title {
    private final String value;

    private Title(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    public  static Title valueOf(String value){
        return Title.valueOf(value);
    }


    @Override
    public String toString() {
        return "Title{" +
                "value='" + value + '\'' +
                '}';
    }
}
