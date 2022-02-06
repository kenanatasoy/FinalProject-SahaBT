package com.example.bookstoremicroservice.category.dto.response;

public class GetCategoryResponse {
    private int cattegoryId;
    private String name;

    public GetCategoryResponse() {
    }

    public int getCattegoryId() {
        return cattegoryId;
    }

    public void setCattegoryId(int cattegoryId) {
        this.cattegoryId = cattegoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
