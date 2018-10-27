package com.kata.bankaccount;

import java.util.Objects;

class Amount {
	private final int value;

	private Amount(int balanceAmount) {
		value = balanceAmount;
	}

	static Amount of(int amount) {
		return new Amount(amount);
	}

	Amount add(int amount) {
		return Amount.of(value + amount);
	}

	Amount subtract(int amount) {
		return Amount.of(value - amount);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Amount)) return false;
		Amount amount = (Amount) o;
		return value == amount.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
