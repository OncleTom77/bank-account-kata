package com.kata.bankaccount;

class Amount {
	private final int value;

	Amount(int balanceAmount) {
		value = balanceAmount;
	}

	int add(int amount) {
		return value + amount;
	}

	int subtract(int amount) {
		return value - amount;
	}
}
