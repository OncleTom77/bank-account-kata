package com.kata.bankaccount;

import java.math.BigDecimal;
import java.util.Objects;

class Amount {
	private final BigDecimal value;

	private Amount(BigDecimal balanceAmount) {
		value = balanceAmount;
	}

	static Amount of(double amount) {
		return of(BigDecimal.valueOf(amount));
	}

	private static Amount of(BigDecimal amount) {
		if (isNegative(amount)) {
			throw new IllegalArgumentException("Amount must not be negative");
		}
		return new Amount(amount);
	}

	private static boolean isNegative(BigDecimal balanceAmount) {
		return balanceAmount.compareTo(BigDecimal.ZERO) < 0;
	}

	Amount add(Amount amount) {
		return Amount.of(value.add(amount.value));
	}

	Amount subtract(Amount amount) {
		return Amount.of(value.subtract(amount.value));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Amount)) return false;
		Amount amount = (Amount) o;
		return Objects.equals(value, amount.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
