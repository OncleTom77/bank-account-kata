package com.kata.bankaccount;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Account {
	private final DateProvider dateProvider;
	private Amount balanceAmount;
	private List<Operation> operations;

	public Account(DateProvider dateProvider, Amount amount) {
		this.dateProvider = dateProvider;
		this.balanceAmount = amount;
		operations = new ArrayList<>();
	}

	static Account of(DateProvider dateProvider, int amount) {
		return new Account(dateProvider, Amount.of(amount));
	}

	Amount deposit(Amount amount) {
		balanceAmount = balanceAmount.add(amount);
		operations.add(Operation.deposit(amount, balanceAmount, dateProvider.now()));
		return balanceAmount;
	}

	Amount withdraw(Amount amount) {
		balanceAmount = balanceAmount.subtract(amount);
		operations.add(Operation.withdrawal(amount, balanceAmount, null));
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
