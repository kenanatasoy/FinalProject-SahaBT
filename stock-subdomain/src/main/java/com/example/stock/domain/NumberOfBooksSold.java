package com.example.stock.domain;

public final class NumberOfBooksSold {

	public static final NumberOfBooksSold EMPTY = new NumberOfBooksSold(0);
	private final int value;

	private NumberOfBooksSold(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static NumberOfBooksSold of(int value) {
		if (value < 0)
			throw new IllegalArgumentException("Sell number should be a positive value");
		return new NumberOfBooksSold(value);
	}

	@Override
	public String toString() {
		return "SellNumber [value=" + value + "]";
	}

	public NumberOfBooksSold add(int item) {
		return NumberOfBooksSold.of(value + item);
	}

	public NumberOfBooksSold subtract(int soldItems) {
		return NumberOfBooksSold.of(value - soldItems);
	}

	public boolean isLessThan(NumberOfBooksSold other) {
		return this.value < other.value;
	}

}
