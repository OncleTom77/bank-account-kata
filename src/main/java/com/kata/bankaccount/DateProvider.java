package com.kata.bankaccount;

import java.time.LocalDateTime;

@FunctionalInterface
interface DateProvider {

	LocalDateTime now();
}
