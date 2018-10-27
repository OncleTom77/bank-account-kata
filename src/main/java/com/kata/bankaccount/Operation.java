package com.kata.bankaccount;

import java.util.Objects;

class Operation {

	private final OperationType type;
	private final Amount amount;

	private Operation(OperationType type, Amount amount) {
		this.type = type;
		this.amount = amount;
	}

	static Operation deposit(Amount amount) {
		return new Operation(OperationType.DEPOSIT, amount);
	}

	static Operation withdrawal(Amount amount) {
		return new Operation(OperationType.WITHDRAWAL, amount);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Operation)) return false;
		Operation operation = (Operation) o;
		return type == operation.type &&
				Objects.equals(amount, operation.amount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, amount);
	}
}
