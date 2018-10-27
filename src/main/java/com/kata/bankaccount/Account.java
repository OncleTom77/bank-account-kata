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
		return 0;
	}
}
