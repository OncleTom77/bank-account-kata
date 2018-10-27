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

		account.deposit(Amount.of(depositAmount));

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

		account.withdraw(Amount.of(withdrawalAmount));

		assertThat(account).isEqualTo(Account.of(expectedAmount));
	}

	@Parameters({
			"0, 0, 0",
			"1, 0, 1", "3, 0, 3",
			"0, 1, 1", "0, 3, 3",
			"1, 1, 2", "3, 5, 8",
	})
	@Test
	public void should_see_as_much_operations_as_deposit_and_withdrawal_operations(int nbDepositOperations, int nbWithdrawalOperations, int nbExpectedOperations) {
		Account account = Account.of(10);
		for (int i = 0; i < nbDepositOperations; i++) {
			account.deposit(Amount.of(1));
		}
		for (int i = 0; i < nbWithdrawalOperations; i++) {
			account.withdraw(Amount.of(1));
		}

		List<Operation> operations = account.getOperationsHistory();

		assertThat(operations).hasSize(nbExpectedOperations);
	}

	@Test
	public void should_see_1_deposit_operation_with_amount_and_balance_in_history_when_1_deposit_operation_is_done() {
		Account account = Account.of(0);
		Amount depositAmount = Amount.of(1);
		account.deposit(depositAmount);

		List<Operation> operations = account.getOperationsHistory();

		Amount balanceAmount = Amount.of(1);
		assertThat(operations).hasSize(1);
		assertThat(operations.get(0)).isEqualTo(Operation.deposit(depositAmount, balanceAmount));
	}

	@Test
	public void should_see_1_deposit_operation_with_amount_and_balance_in_history_when_1_deposit_operation_is_done_2() {
		Account account = Account.of(1);
		Amount depositAmount = Amount.of(1);
		account.deposit(depositAmount);

		List<Operation> operations = account.getOperationsHistory();

		Amount balanceAmount = Amount.of(2);
		assertThat(operations).hasSize(1);
		assertThat(operations.get(0)).isEqualTo(Operation.deposit(depositAmount, balanceAmount));
	}

	@Test
	public void should_see_1_withdrawal_operation_with_amount_and_balance_in_history_when_1_withdrawal_operation_is_done() {
		Account account = Account.of(10);
		Amount withdrawalAmount = Amount.of(1);
		account.withdraw(withdrawalAmount);

		List<Operation> operations = account.getOperationsHistory();

		Amount balanceAmount = Amount.of(9);
		assertThat(operations).hasSize(1);
		assertThat(operations.get(0)).isEqualTo(Operation.withdrawal(withdrawalAmount, balanceAmount));
	}
}
