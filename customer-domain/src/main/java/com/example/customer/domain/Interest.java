package com.example.customer.domain;

import java.util.Objects;

public final class Interest {

    private final String interest;

    private Interest(String interest) {
        this.interest = interest;
    }

    public static Interest valueOf(String interest) {
        if (Objects.isNull(interest))
            throw new IllegalArgumentException("Currency can not be null");
        return new Interest(interest);
    }

    public String getInterest() {
        return interest;
    }

    @Override
    public String toString() {
        return "Interest{" +
                "interest='" + interest + '\'' +
                '}';
    }
}
