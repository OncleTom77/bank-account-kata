package com.kata.bankaccount;

import java.util.Collections;
import java.util.List;

class Account {
	private int balanceAmount;

	public Account(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	int deposit(int amount) {
		return balanceAmount + amount;
	}

	int withdraw(int amount) {
		return balanceAmount - amount;
	}

	List<Operation> getOperationsHistory() {
		return Collections.emptyList();
	}
}
