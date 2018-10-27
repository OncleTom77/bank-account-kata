package com.kata.bankaccount;

import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class AccountTest {

	@Test
	public void should_see_empty_operations_history() {
		Account account = Account.of(0);

		List<Operation> operations = account.getOperationsHistory();

		assertThat(operations).isEmpty();
	}
}
