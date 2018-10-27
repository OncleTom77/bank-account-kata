package com.kata.bankaccount;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class AmountTest {

	@Parameters({
			"0, 0, 0",
			"0, 1, 1", "0, 7, 7",
			"2, 0, 2", "8, 0, 8",
			"1, 2, 3", "2, 2, 4", "3, 2, 5", "9, 4, 13", "6, 15, 21"
	})
	@Test
	public void should_add_amount(int baseAmount, int amountToAdd, int expectedAmount) {
		Amount amount = Amount.of(baseAmount);

		Amount result = amount.add(Amount.of(amountToAdd));

		assertThat(result).isEqualTo(Amount.of(expectedAmount));
	}

	@Parameters({
			"0, 0, 0",
			"1, 0, 1", "3, 0, 3",
			"5, 1, 4", "5, 2, 3", "5, 3, 2"
	})
	@Test
	public void should_subtract_amount(int baseAmount, int amountToSubtract, int expectedAmount) {
		Amount amount = Amount.of(baseAmount);

		Amount result = amount.subtract(Amount.of(amountToSubtract));

		assertThat(result).isEqualTo(Amount.of(expectedAmount));
	}
}
