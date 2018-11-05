package com.kata.bankaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Account {
	private final DateProvider dateProvider;
	private Amount balance;
	private List<Operation> operations;

	private Account(DateProvider dateProvider, Amount amount) {
		this.dateProvider = dateProvider;
		balance = Amount.of(0);
		operations = new ArrayList<>();

		deposit(amount);
	}

	static Account of(DateProvider dateProvider, int amount) {
		return new Account(dateProvider, Amount.of(amount));
	}

	void deposit(Amount amount) {
		balance = balance.add(amount);
		operations.add(DepositOperation.of(amount, balance, dateProvider.now()));
	}

	void withdraw(Amount amount) {
		balance = balance.subtract(amount);
		operations.add(WithdrawalOperation.of(amount, balance, dateProvider.now()));
	}

	List<Operation> getOperationsHistory() {
		return operations;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Account)) return false;
		Account account = (Account) o;
		return Objects.equals(balance, account.balance);
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance);
	}
}
