package com.kata.bankaccount;

class Amount {
	private final int value;

	private Amount(int balanceAmount) {
		value = balanceAmount;
	}

	static Amount of(int amount) {
		return new Amount(amount);
	}

	int add(int amount) {
		return value + amount;
	}

	int subtract(int amount) {
		return value - amount;
	}
}
