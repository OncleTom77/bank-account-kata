package com.kata.bankaccount;

import java.util.Objects;

class Operation {

	private final OperationType type;

	Operation() {
		type = null;
	}

	private Operation(OperationType type) {
		this.type = type;
	}

	static Operation deposit() {
		return new Operation(OperationType.DEPOSIT);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Operation)) return false;
		Operation operation = (Operation) o;
		return type == operation.type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(type);
	}
}
