package com.kata.bankaccount;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

	@Test
	public void should_add_0_amount_to_balance() {
		Account account = new Account(0);

		int balance = account.deposit(0);

		assertThat(balance).isEqualTo(0);
	}

	@Test
	public void should_add_1_amount_to_balance() {
		Account account = new Account(0);

		int balance = account.deposit(1);

		assertThat(balance).isEqualTo(1);
	}

	@Test
	public void should_add_2_amount_to_balance() {
		Account account = new Account(0);

		int balance = account.deposit(2);

		assertThat(balance).isEqualTo(2);
	}

	@Test
	public void should_get_balance_when_deposit_0_amount() {
		Account account = new Account(1);

		int balance = account.deposit(0);

		assertThat(balance).isEqualTo(1);
	}
}
