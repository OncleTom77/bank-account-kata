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

	@Test
	public void should_get_balance_amount_when_deposit_amount_is_0() {
		Account account = new Account(1);

		int balance = account.deposit(0);

		assertThat(balance).isEqualTo(1);
	}

	@Test
	public void should_get_balance_amount_when_deposit_amount_is_0_2() {
		Account account = new Account(2);

		int balance = account.deposit(0);

		assertThat(balance).isEqualTo(2);
	}

	@Test
	public void should_get_balance_amount_when_deposit_amount_is_0_3() {
		Account account = new Account(3);

		int balance = account.deposit(0);

		assertThat(balance).isEqualTo(3);
	}
}
