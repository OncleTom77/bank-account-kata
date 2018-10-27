package com.kata.bankaccount;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

	@Test
	public void should_add_0_amount_to_balance() {
		int balance = new Account().deposit(0);

		assertThat(balance).isEqualTo(0);
	}

	@Test
	public void should_add_1_amount_to_balance() {
		int balance = new Account().deposit(1);

		assertThat(balance).isEqualTo(1);
	}

	@Test
	public void should_add_2_amount_to_balance() {
		int balance = new Account().deposit(2);

		assertThat(balance).isEqualTo(2);
	}

}
