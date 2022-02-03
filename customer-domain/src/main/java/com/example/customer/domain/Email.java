package com.example.customer.domain;

import java.util.regex.Pattern;


public final class Email {

    private final String value;
    private static final String regex = "^(.+)@(\\S+)$";

    private Email(String value) {
        this.value = value;
    }

    public static Email valueOf(String value) {
        if (!patternMatches(value))
            throw new IllegalArgumentException("Email must follow the mail standards");
        return new Email(value);
    }

    public static boolean patternMatches(String emailAddress) {
        return Pattern.compile(regex)
                .matcher(emailAddress)
                .matches();
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Email{" +
                "value='" + value + '\'' +
                '}';
    }
}
