package com.example.bookstoremicroservice.stock.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class StockDocument {

    @Id
    private String stockKeepingUnit;

    @Indexed
    private String isbn;

    private int numberOfBooksLeft;

    private int numberOfBooksSold;

    public StockDocument() {
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
    public int hashCode() {
        return Objects.hash(stockKeepingUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StockDocument other = (StockDocument) obj;
        return Objects.equals(stockKeepingUnit, other.stockKeepingUnit);
    }

    @Override
    public String toString() {
        return "StockDocument{" +
                "stockKeepingUnit='" + stockKeepingUnit + '\'' +
                ", isbn='" + isbn + '\'' +
                ", numberOfBooksLeft=" + numberOfBooksLeft +
                ", numberOfBooksSold=" + numberOfBooksSold +
                '}';
    }
}
