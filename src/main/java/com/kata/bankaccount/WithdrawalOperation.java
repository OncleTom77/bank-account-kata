package com.kata.bankaccount;

import java.time.LocalDateTime;

class WithdrawalOperation extends Operation {
    private WithdrawalOperation(Amount amount, Amount balanceAmount, LocalDateTime operationDate) {
        super(amount, balanceAmount, operationDate);
    }

    static Operation of(Amount amount, Amount balanceAmount, LocalDateTime operationDate) {
        return new WithdrawalOperation(amount, balanceAmount, operationDate);
    }

    @Override
    public boolean equals(Object o) {
        if (! (o instanceof WithdrawalOperation)) return false;
        return super.equals(o);
    }
}
