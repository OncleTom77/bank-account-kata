package com.kata.bankaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Account {
	private Amount balanceAmount;
	private List<Operation> operations;

	private Account(Amount amount) {
		this.balanceAmount = amount;
		operations = new ArrayList<>();
	}

	static Account of(int amount) {
		return new Account(Amount.of(amount));
	}

	Amount deposit(int amount) {
		operations.add(Operation.deposit(Amount.of(amount)));
		balanceAmount = balanceAmount.add(amount);
		return balanceAmount;
	}

	Amount withdraw(int amount) {
		operations.add(Operation.withdrawal());
		balanceAmount = balanceAmount.subtract(amount);
		return balanceAmount;
	}

	List<Operation> getOperationsHistory() {
		return operations;
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
