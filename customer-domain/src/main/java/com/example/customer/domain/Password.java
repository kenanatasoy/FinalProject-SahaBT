package com.example.customer.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Password {
    private final String value;
    private static final String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";

    private Password(String value) {
        this.value = value;
    }

    public static Password valueOf(String value) {
        if (!isValidPassword(value))
            throw new IllegalArgumentException("Password should follow standarda password rules");
        return new Password(value);
    }

    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }


}
