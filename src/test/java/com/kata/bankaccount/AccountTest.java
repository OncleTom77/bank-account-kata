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
			"0, 1, 1", "0, 3, 3",
			"1, 0, 1", "3, 0, 3",
			"5, 3, 8", "2, 9, 11"
	})
	@Test
	public void should_update_account_balance_when_deposit_positive_amount(int balanceAmount, int depositAmount, int expectedAmount) {
		Account account = Account.of(balanceAmount);

		account.deposit(depositAmount);

		assertThat(account).isEqualTo(Account.of(expectedAmount));
	}

	@Test
	public void should_update_account_balance_when_withdraw_positive_amount() {
		Account account = Account.of(3);

		account.withdraw(1);

		assertThat(account).isEqualTo(Account.of(2));
	}

	@Test
	public void should_update_account_balance_when_withdraw_positive_amount_2() {
		Account account = Account.of(3);

		account.withdraw(2);

		assertThat(account).isEqualTo(Account.of(1));
	}

	@Test
	public void should_update_account_balance_when_withdraw_positive_amount_3() {
		Account account = Account.of(3);

		account.withdraw(3);

		assertThat(account).isEqualTo(Account.of(0));
	}

	@Test
	public void should_see_empty_operations_history() {
		Account account = Account.of(0);

		List<Operation> operations = account.getOperationsHistory();

		assertThat(operations).isEmpty();
	}
}
