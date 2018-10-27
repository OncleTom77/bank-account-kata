package com.kata.bankaccount;

class Account {
	private int balanceAmount;

	public Account(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	int deposit(int amount) {
		if (balanceAmount > 0) {
			return balanceAmount;
		}
		return amount;
	}
}
