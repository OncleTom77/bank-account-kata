package com.kata.bankaccount;

import java.time.LocalDateTime;
import java.util.Objects;

abstract class Operation {

	private final Amount amount;
	private final Amount balanceAmount;
	private final LocalDateTime operationDate;

	Operation(Amount amount, Amount balanceAmount, LocalDateTime operationDate) {
		this.amount = amount;
		this.balanceAmount = balanceAmount;
		this.operationDate = operationDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Operation)) return false;
		Operation operation = (Operation) o;
		return Objects.equals(amount, operation.amount) &&
				Objects.equals(balanceAmount, operation.balanceAmount) &&
				Objects.equals(operationDate, operation.operationDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, balanceAmount, operationDate);
	}
}
