package com.kata.bankaccount;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Account {
	private Amount balanceAmount;

	private Account(Amount amount) {
		this.balanceAmount = amount;
	}

	static Account of(int amount) {
		return new Account(Amount.of(amount));
	}

	Amount deposit(int amount) {
		balanceAmount = Amount.of(1);
		return balanceAmount.add(amount);
	}

	Amount withdraw(int amount) {
		return balanceAmount.subtract(amount);
	}

	List<Operation> getOperationsHistory() {
		return Collections.emptyList();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Account)) return false;
		Account account = (Account) o;
		return Objects.equals(balanceAmount, account.balanceAmount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(balanceAmount);
	}
}
