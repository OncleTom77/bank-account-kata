package com.kata.bankaccount;

class Account {
	private int balanceAmount;

	public Account() {
	}

	public Account(int balanceAmount) {

		this.balanceAmount = balanceAmount;
	}

	int deposit(int amount) {
		if (balanceAmount > 0) {
			return 1;
		}
		return amount;
	}
}
