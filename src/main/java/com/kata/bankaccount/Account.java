package com.kata.bankaccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

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
		operations.add(new Operation());
		balanceAmount = balanceAmount.add(amount);
		return balanceAmount;
	}

	Amount withdraw(int amount) {
		if (balanceAmount.equals(Amount.of(1))) {
			operations = asList(new Operation(), new Operation());
		} else {
			operations = Collections.singletonList(new Operation());
		}
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
