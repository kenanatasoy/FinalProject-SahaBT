package com.example.domain.category;

import java.util.Objects;

public class Name {
    private final String categoryName;

    private Name(String categoryName) {
        this.categoryName = categoryName;
    }
    public static Name of(String categoryName){
        Objects.requireNonNull(categoryName);
        if (categoryName.length() < 5)
            throw new IllegalArgumentException("CategoryName should have at least five characters");
        return new Name(categoryName);
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "categoryName='" + categoryName + '\'' +
                '}';
    }
}
