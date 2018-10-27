package com.kata.bankaccount;

import java.math.BigDecimal;
import java.util.Objects;

class Amount {
	private final BigDecimal value;

	private Amount(BigDecimal balanceAmount) {
		if (balanceAmount.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Amount must not be negative");
		}
		value = balanceAmount;
	}

	static Amount of(double amount) {
		return of(BigDecimal.valueOf(amount));
	}

	static Amount of(BigDecimal amount) {
		return new Amount(amount);
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
