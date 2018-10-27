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

	@Parameters({
			"0, 0, 0",
			"1, 0, 1", "3, 0, 3",
			"5, 3, 2", "9, 2, 7"
	})
	@Test
	public void should_update_account_balance_when_withdraw_positive_amount(int balanceAmount, int withdrawalAmount, int expectedAmount) {
		Account account = Account.of(balanceAmount);

		account.withdraw(withdrawalAmount);

		assertThat(account).isEqualTo(Account.of(expectedAmount));
	}

	@Test
	public void should_see_empty_operations_history_when_0_deposit() {
		Account account = Account.of(0);

		List<Operation> operations = account.getOperationsHistory();

		assertThat(operations).isEmpty();
	}

	@Test
	public void should_see_1_operation_in_history_when_1_deposit() {
		Account account = Account.of(0);
		account.deposit(1);

		List<Operation> operations = account.getOperationsHistory();

		assertThat(operations).hasSize(1);
	}

	@Test
	public void should_see_2_operations_in_history_when_2_deposit() {
		Account account = Account.of(0);
		account.deposit(1);
		account.deposit(1);

		List<Operation> operations = account.getOperationsHistory();

		assertThat(operations).hasSize(2);
	}

	@Test
	public void should_see_1_operation_in_history_when_1_withdrawal() {
		Account account = Account.of(2);
		account.withdraw(1);

		List<Operation> operations = account.getOperationsHistory();

		assertThat(operations).hasSize(1);
	}
}
