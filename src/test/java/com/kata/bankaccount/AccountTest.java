package com.kata.bankaccount;

import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class AccountTest {

	@Test
	public void should_update_account_balance_when_deposit_positive_amount() {
		Account account = Account.of(0);

		account.deposit(1);

		assertThat(account).isEqualTo(Account.of(1));
	}

	@Test
	public void should_update_account_balance_when_deposit_positive_amount_2() {
		Account account = Account.of(0);

		account.deposit(2);

		assertThat(account).isEqualTo(Account.of(2));
	}

	@Test
	public void should_update_account_balance_when_deposit_positive_amount_3() {
		Account account = Account.of(1);

		account.deposit(1);

		assertThat(account).isEqualTo(Account.of(2));
	}

	@Test
	public void should_see_empty_operations_history() {
		Account account = Account.of(0);

		List<Operation> operations = account.getOperationsHistory();

		assertThat(operations).isEmpty();
	}
}
