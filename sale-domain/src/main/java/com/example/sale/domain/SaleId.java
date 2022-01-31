package com.example.sale.domain;

public final class SaleId {

    private final int saleId;

    private SaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getSaleId() {
        return saleId;
    }

    public static SaleId valueOf(int saleId){

        return new SaleId(saleId);
    }

    @Override
    public String toString() {
        return "SaleId{" +
                "saleId=" + saleId +
                '}';
    }
}
