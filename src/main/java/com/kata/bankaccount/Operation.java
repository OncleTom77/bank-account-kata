package com.kata.bankaccount;

import java.util.Objects;

class Operation {

	private final OperationType type;
	private final int amount;

	private Operation(OperationType type) {
		this.type = type;
		amount = 0;
	}

	private Operation(OperationType withdrawal, int amount) {
		type = withdrawal;
		this.amount = amount;
	}

	static Operation deposit() {
		return new Operation(OperationType.DEPOSIT);
	}

	static Operation withdrawal() {
		return new Operation(OperationType.WITHDRAWAL);
	}

	static Operation deposit(int amount) {
		return new Operation(OperationType.DEPOSIT, amount);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Operation)) return false;
		Operation operation = (Operation) o;
		return amount == operation.amount &&
				type == operation.type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, amount);
	}
}
