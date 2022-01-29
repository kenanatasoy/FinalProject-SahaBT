package com.example.domain;

import java.util.Objects;

public class SubCategory {
    private final String subCategoryName;

    private SubCategory(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public static SubCategory of(String subCategoryName){
        Objects.requireNonNull(subCategoryName);
        if (subCategoryName.length() < 6 )
            throw new IllegalArgumentException("SubCategory should have at least six characters");
        return new SubCategory(subCategoryName);
    }


    public String getSubCategoryName() {
        return subCategoryName;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "subCategoryName='" + subCategoryName + '\'' +
                '}';
    }
}
