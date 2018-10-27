package com.kata.bankaccount;

import java.util.Collections;
import java.util.List;

class Account {
	private Amount balanceAmount;

	private Account(Amount amount) {
		this.balanceAmount = amount;
	}

	static Account of(int amount) {
		return new Account(Amount.of(amount));
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
