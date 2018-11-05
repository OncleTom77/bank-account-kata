package com.kata.bankaccount;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class AmountTest {

	@Test
	public void should_add_amount() {
		int initialAmount = 7;
		Amount amount = Amount.of(initialAmount);

		int amountToAdd = 4;
		Amount result = amount.add(Amount.of(amountToAdd));

		assertThat(result).isEqualTo(Amount.of(initialAmount + amountToAdd));
	}

	@Test
	public void should_subtract_amount() {
		int initialAmount = 5;
		Amount amount = Amount.of(initialAmount);

		int amountToSubtract = 3;
		Amount result = amount.subtract(Amount.of(amountToSubtract));

		assertThat(result).isEqualTo(Amount.of(initialAmount - amountToSubtract));
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_not_instantiate_negative_amount() {
		Amount.of(-1);
	}
}
