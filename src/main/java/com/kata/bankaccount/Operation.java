package com.kata.bankaccount;

import java.util.Objects;

class Operation {

	private final OperationType type;
	private final Amount amount;
	private final Amount balanceAmount;

	private Operation(OperationType type, Amount amount, Amount balanceAmount) {
		this.type = type;
		this.amount = amount;
		this.balanceAmount = balanceAmount;
	}

	static Operation deposit(Amount amount, Amount balanceAmount) {
		return new Operation(OperationType.DEPOSIT, amount, balanceAmount);
	}

	static Operation withdrawal(Amount amount) {
		return new Operation(OperationType.WITHDRAWAL, amount, null);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Operation)) return false;
		Operation operation = (Operation) o;
		return type == operation.type &&
				Objects.equals(amount, operation.amount) &&
				Objects.equals(balanceAmount, operation.balanceAmount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, amount, balanceAmount);
	}
}
