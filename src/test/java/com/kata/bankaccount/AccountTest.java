package com.kata.bankaccount;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class AccountTest {

	@Parameters({"0", "1", "2", "3", "7", "10"})
	@Test
	public void should_get_deposit_amount_when_balance_amount_is_0(int depositAmount) {
		Account account = new Account(0);

		int balance = account.deposit(depositAmount);

		assertThat(balance).isEqualTo(depositAmount);
	}

	@Parameters({"0", "1", "2", "5", "9", "15"})
	@Test
	public void should_get_balance_amount_when_deposit_amount_is_0(int balanceAmount) {
		Account account = new Account(balanceAmount);

		int balance = account.deposit(0);

		assertThat(balance).isEqualTo(balanceAmount);
	}

	@Test
	public void should_add_deposit_amount_to_balance_amount_when_amounts_are_positives() {
		Account account = new Account(1);

		int balance = account.deposit(1);

		assertThat(balance).isEqualTo(2);
	}
}
