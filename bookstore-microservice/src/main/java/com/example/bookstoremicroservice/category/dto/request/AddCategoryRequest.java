package com.example.bookstoremicroservice.category.dto.request;

public class AddCategoryRequest {
    private String catalogId;
    private String name;

    public AddCategoryRequest() {
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
