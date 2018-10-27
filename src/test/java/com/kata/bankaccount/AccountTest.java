package com.kata.bankaccount;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class AccountTest {

	@Parameters({"0, 1", "0, 7", "2, 0", "8, 0", "1, 2", "2, 2", "3, 2", "9, 4", "6, 15"})
	@Test
	public void should_deposit_amount_to_balance_amount(int balanceAmount, int depositAmount) {
		Account account = new Account(balanceAmount);

		int balance = account.deposit(depositAmount);

		assertThat(balance).isEqualTo(balanceAmount + depositAmount);
	}

	@Parameters({"0", "1", "2", "5"})
	@Test
	public void should_get_balance_amount_when_withdrawal_amount_is_0(int balanceAmount) {
		Account account = new Account(balanceAmount);

		int balance = account.withdraw(0);

		assertThat(balance).isEqualTo(balanceAmount);
	}
}
