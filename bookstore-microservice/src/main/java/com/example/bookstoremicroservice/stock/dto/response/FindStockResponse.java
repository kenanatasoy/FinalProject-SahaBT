package com.example.bookstoremicroservice.stock.dto.response;

public class FindStockResponse {

    private String stockKeepingUnit;

    private String isbn;

    private int numberOfBooksLeft;

    private int numberOfBooksSold;

    public FindStockResponse() {
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
        return "FindStockResponse{" +
                "isbn='" + isbn + '\'' +
                ", numberOfBooksLeft=" + numberOfBooksLeft +
                ", numberOfBooksSold=" + numberOfBooksSold +
                '}';
    }

}
