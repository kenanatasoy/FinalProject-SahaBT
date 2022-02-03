package com.example.stock.domain;

public final class NumberOfBooksLeft {

	public static final NumberOfBooksLeft EMPTY = new NumberOfBooksLeft(0);
	private final int value;

	private NumberOfBooksLeft(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static NumberOfBooksLeft of(int value) {
		if (value < 0)
			throw new IllegalArgumentException("Stock number should be a positive value");
		return new NumberOfBooksLeft(value);
	}

	@Override
	public String toString() {
		return "StockNumber [value=" + value + "]";
	}

	public NumberOfBooksLeft add(int item) {
		return NumberOfBooksLeft.of(value + item);
	}

	public NumberOfBooksLeft drop(int soldItems) {
		return NumberOfBooksLeft.of(value - soldItems);
	}

	public boolean isLessThan(NumberOfBooksLeft other) {
		return this.value < other.value;
	}

	public boolean isLessThanSellNumber(NumberOfBooksSold other) {
		return this.value < other.getValue();
	}

}
