package com.example.bookstoremicroservice.category.dto.response;

public class AddedCategoryResponse {
    private String catalogId;
    private String name;

    public AddedCategoryResponse() {
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
