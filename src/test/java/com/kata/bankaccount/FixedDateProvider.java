package com.kata.bankaccount;

import java.time.LocalDateTime;

public class FixedDateProvider implements DateProvider {

	private final LocalDateTime fixedDate;

	FixedDateProvider(LocalDateTime fixedDate) {
		this.fixedDate = fixedDate;
	}

	@Override
	public LocalDateTime now() {
		return fixedDate;
	}
}
