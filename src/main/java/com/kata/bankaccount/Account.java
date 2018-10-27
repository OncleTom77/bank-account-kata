package com.kata.bankaccount;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Account {
	private Amount balanceAmount;
	private Operation operation;

	private Account(Amount amount) {
		this.balanceAmount = amount;
		operation = null;
	}

	static Account of(int amount) {
		return new Account(Amount.of(amount));
	}

	Amount deposit(int amount) {
		operation = new Operation();
		balanceAmount = balanceAmount.add(amount);
		return balanceAmount;
	}

	Amount withdraw(int amount) {
		balanceAmount = balanceAmount.subtract(amount);
		return balanceAmount;
	}

	List<Operation> getOperationsHistory() {
		if (operation != null) {
			return Collections.singletonList(operation);
		}
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
