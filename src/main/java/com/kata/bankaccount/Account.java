package com.kata.bankaccount;

import java.util.Collections;
import java.util.List;

class Account {
	private Amount balanceAmount;

	public Account(Amount amount) {
		this.balanceAmount = amount;
	}

	int deposit(int amount) {
		return balanceAmount.add(amount);
	}

	int withdraw(int amount) {
		return balanceAmount.subtract(amount);
	}

	List<Operation> getOperationsHistory() {
		return Collections.emptyList();
	}
}
