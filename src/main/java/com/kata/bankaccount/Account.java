package com.kata.bankaccount;

class Account {
	private int balanceAmount;

	public Account(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	int deposit(int amount) {
		return balanceAmount + amount;
	}

	int withdraw(int amount) {
		if (amount > 0) {
			return 4;
		}
		return balanceAmount;
	}
}
