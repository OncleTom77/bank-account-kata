package com.kata.bankaccount;

import java.time.LocalDateTime;

public class DateProviderTest implements DateProvider {

	private final LocalDateTime dateToReturn;

	DateProviderTest(LocalDateTime dateToReturn) {
		this.dateToReturn = dateToReturn;
	}

	@Override
	public LocalDateTime now() {
		return dateToReturn;
	}
}
