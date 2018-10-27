package com.kata.bankaccount;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class AccountTest {

	@Parameters({
			"0, 0, 0",
			"0, 1, 1", "0, 7, 7",
			"2, 0, 2", "8, 0, 8",
			"1, 2, 3", "2, 2, 4", "3, 2, 5", "9, 4, 13", "6, 15, 21"
	})
	@Test
	public void should_deposit_amount_to_balance_amount(int balanceAmount, int depositAmount, int expectedResult) {
		Account account = Account.of(balanceAmount);

		Amount balance = account.deposit(depositAmount);

		assertThat(balance).isEqualTo(Amount.of(expectedResult));
	}

	@Parameters({
			"0, 0, 0",
			"1, 0, 1", "3, 0, 3",
			"5, 1, 4", "5, 2, 3", "5, 3, 2"
	})
	@Test
	public void should_withdraw_positive_amount(int balanceAmount, int withdrawalAmount, int expectedResult) {
		Account account = Account.of(balanceAmount);

		Amount balance = account.withdraw(withdrawalAmount);

		assertThat(balance).isEqualTo(Amount.of(expectedResult));
	}

	@Test
	public void should_see_empty_operations_history() {
		Account account = Account.of(0);

		List<Operation> operations = account.getOperationsHistory();

		assertThat(operations).isEmpty();
	}
}
