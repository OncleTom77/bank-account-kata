package com.kata.bankaccount;

import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class AccountTest {

	private static final LocalDateTime OPERATION_DATE = LocalDateTime.of(2018, Month.OCTOBER, 27, 17, 0);
	private final DateProvider fixedDateProvider = new FixedDateProvider(OPERATION_DATE);

	@Test
	public void should_update_account_balance_when_deposit_positive_amount() {
		int initialAmount = 2;
		Account account = Account.of(fixedDateProvider, initialAmount);

		int depositAmount = 9;
		account.deposit(Amount.of(depositAmount));

		assertThat(account).isEqualTo(Account.of(fixedDateProvider, initialAmount + depositAmount));
	}

	@Test
	public void should_update_account_balance_when_withdraw_positive_amount() {
		int initialAmount = 9;
		Account account = Account.of(fixedDateProvider, initialAmount);

		int withdrawalAmount = 2;
		account.withdraw(Amount.of(withdrawalAmount));

		assertThat(account).isEqualTo(Account.of(fixedDateProvider, initialAmount - withdrawalAmount));
	}

	@Test
	public void should_see_as_many_operations_as_deposit_and_withdrawal_operations() {
		Account account = Account.of(fixedDateProvider, 10);
		account.deposit(Amount.of(1));
		account.deposit(Amount.of(1));
		account.withdraw(Amount.of(1));
		account.deposit(Amount.of(1));
		account.withdraw(Amount.of(1));

		List<Operation> operations = account.getOperationsHistory();

		int nbExpectedOperations = 6;
		assertThat(operations).hasSize(nbExpectedOperations);
	}

	@Test
	public void should_see_1_deposit_operation_at_account_creation() {
		int initialAmount = 3;
		Account account = Account.of(fixedDateProvider, initialAmount);

		List<Operation> operations = account.getOperationsHistory();

		Operation expectedOperation = DepositOperation.of(
				Amount.of(initialAmount),
				Amount.of(initialAmount),
				OPERATION_DATE
		);
		assertThat(operations).contains(expectedOperation);
	}

	@Test
	public void should_see_1_correct_deposit_operation_in_history_when_1_deposit_operation_is_done() {
		int initialAmount = 3;
		Account account = Account.of(fixedDateProvider, initialAmount);
		int depositAmount = 5;
		account.deposit(Amount.of(depositAmount));

		List<Operation> operations = account.getOperationsHistory();

		Operation expectedOperation = DepositOperation.of(
				Amount.of(depositAmount),
				Amount.of(initialAmount + depositAmount),
				OPERATION_DATE
		);
		assertThat(operations).contains(expectedOperation);
	}

	@Test
	public void should_see_1_correct_withdrawal_operation_in_history_when_1_withdrawal_operation_is_done() {
		int initialAmount = 10;
		Account account = Account.of(fixedDateProvider, initialAmount);
		int withdrawalAmount = 4;
		account.withdraw(Amount.of(withdrawalAmount));

		List<Operation> operations = account.getOperationsHistory();

		Operation expectedOperation = WithdrawalOperation.of(
				Amount.of(withdrawalAmount),
				Amount.of(initialAmount - withdrawalAmount),
				OPERATION_DATE
		);
		assertThat(operations).contains(expectedOperation);
	}
}
