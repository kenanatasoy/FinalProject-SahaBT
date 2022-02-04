package com.example.bookstoremicroservice.sale.dto.response;

import java.time.LocalDateTime;

public class MakeSaleResponse {

    private int saleId;
    private LocalDateTime saleDateTime;

    public MakeSaleResponse() {
    }

    public int getSaleId() {
        return saleId;
    }

    public LocalDateTime getSaleDateTime() {
        return saleDateTime;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public void setSaleDateTime(LocalDateTime saleDateTime) {
        this.saleDateTime = saleDateTime;
    }

    @Override
    public String toString() {
        return "MakeSaleResponse{" +
                "saleId=" + saleId +
                ", saleDateTime=" + saleDateTime +
                '}';
    }
}
