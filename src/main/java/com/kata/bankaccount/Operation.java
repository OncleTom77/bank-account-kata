package com.kata.bankaccount;

import java.time.LocalDateTime;
import java.util.Objects;

class Operation {

	private final OperationType type;
	private final Amount amount;
	private final Amount balanceAmount;
	private final LocalDateTime operationDate;

	private Operation(OperationType type, Amount amount, Amount balanceAmount, LocalDateTime operationDate) {
		this.type = type;
		this.amount = amount;
		this.balanceAmount = balanceAmount;
		this.operationDate = operationDate;
	}

	static Operation deposit(Amount amount, Amount balanceAmount, LocalDateTime operationDate) {
		return new Operation(OperationType.DEPOSIT, amount, balanceAmount, operationDate);
	}

	static Operation withdrawal(Amount amount, Amount balanceAmount, LocalDateTime operationDate) {
		return new Operation(OperationType.WITHDRAWAL, amount, balanceAmount, operationDate);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Operation)) return false;
		Operation operation = (Operation) o;
		return type == operation.type &&
				Objects.equals(amount, operation.amount) &&
				Objects.equals(balanceAmount, operation.balanceAmount) &&
				Objects.equals(operationDate, operation.operationDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, amount, balanceAmount, operationDate);
	}
}
