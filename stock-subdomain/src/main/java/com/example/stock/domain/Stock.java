package com.example.stock.domain;

import com.example.shared.domain.Isbn;

import java.util.Objects;

public class Stock {

	private final StockKeepingUnit sku;
	private final Isbn isbn;
	private NumberOfBooksLeft numberOfBooksLeft = NumberOfBooksLeft.EMPTY;
	private NumberOfBooksSold numberOfBooksSold = NumberOfBooksSold.EMPTY;

	private Stock(StockKeepingUnit sku, Isbn isbn) {
		this(sku, isbn, NumberOfBooksLeft.EMPTY, NumberOfBooksSold.EMPTY);
	}

	private Stock(StockKeepingUnit sku, Isbn isbn, NumberOfBooksLeft numberOfBooksLeft, NumberOfBooksSold numberOfBooksSold) {
		this.sku = sku;
		this.isbn = isbn;
		this.numberOfBooksLeft = numberOfBooksLeft;
		this.numberOfBooksSold = numberOfBooksSold;
	}

	public StockKeepingUnit getSku() {
		return sku;
	}

	public Isbn getIsbn() {
		return isbn;
	}

	public NumberOfBooksLeft getNumberOfBooksLeft() {
		return numberOfBooksLeft;
	}

	public NumberOfBooksSold getNumberOfBooksSold() {
		return numberOfBooksSold;
	}

	public NumberOfBooksLeft addStock(int newItems) {
		this.numberOfBooksLeft = numberOfBooksLeft.add(newItems);
		return numberOfBooksLeft;
	}

	public NumberOfBooksLeft sellFromStock(int soldItems) {
		this.numberOfBooksLeft = numberOfBooksLeft.drop(soldItems);
		numberOfBooksSold = numberOfBooksSold.add(soldItems);
		return numberOfBooksLeft;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sku);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return Objects.equals(sku, other.sku);
	}

	@Override
	public String toString() {
		return "Stock [sku=" + sku + ", isbn=" + isbn + ", numberOfBooksLeft=" + numberOfBooksLeft
				+ ", numberOfBooksSold=" + numberOfBooksSold + "]";
	}

	public static class Builder {
		private StockKeepingUnit sku;
		private Isbn isbn;
		private NumberOfBooksLeft numberOfBooksLeft;
		private NumberOfBooksSold numberOfBooksSold;

		public Builder sku(String value) {
			this.sku = StockKeepingUnit.of(value);
			return this;
		}

		public Builder isbn(String value) {
			this.isbn = Isbn.valueOf(value);
			return this;
		}

		public Builder numberOfBooksLeft(int value) {
			this.numberOfBooksLeft = NumberOfBooksLeft.of(value);
			return this;
		}

		public Builder numberOfBooksSold(int value) {
			this.numberOfBooksSold = NumberOfBooksSold.of(value);
			return this;
		}

		public Stock build() {
			return new Stock(sku, isbn, numberOfBooksLeft, numberOfBooksSold);
		}
	}
}
