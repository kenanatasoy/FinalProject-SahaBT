package com.example.bookstoremicroservice.stock.dto.request;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class StockRequest {

    @Id
    private String stockKeepingUnit;

    @Indexed
    private String isbn;

    private int numberOfBooksLeft;

    private int numberOfBooksSold;

    public StockRequest() {
    }

    public String getStockKeepingUnit() {
        return stockKeepingUnit;
    }

    public void setStockKeepingUnit(String stockKeepingUnit) {
        this.stockKeepingUnit = stockKeepingUnit;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumberOfBooksLeft() {
        return numberOfBooksLeft;
    }

    public void setNumberOfBooksLeft(int numberOfBooksLeft) {
        this.numberOfBooksLeft = numberOfBooksLeft;
    }

    public int getNumberOfBooksSold() {
        return numberOfBooksSold;
    }

    public void setNumberOfBooksSold(int numberOfBooksSold) {
        this.numberOfBooksSold = numberOfBooksSold;
    }

    @Override
    public String toString() {
        return "StockRequest{" +
                "stockKeepingUnit='" + stockKeepingUnit + '\'' +
                ", isbn='" + isbn + '\'' +
                ", numberOfBooksLeft=" + numberOfBooksLeft +
                ", numberOfBooksSold=" + numberOfBooksSold +
                '}';
    }

}
