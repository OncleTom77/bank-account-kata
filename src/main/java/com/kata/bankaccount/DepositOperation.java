package com.kata.bankaccount;

import java.time.LocalDateTime;

class DepositOperation extends Operation {
    private DepositOperation(Amount amount, Amount balanceAmount, LocalDateTime operationDate) {
        super(amount, balanceAmount, operationDate);
    }

    static Operation of(Amount amount, Amount balanceAmount, LocalDateTime operationDate) {
        return new DepositOperation(amount, balanceAmount, operationDate);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DepositOperation)) return false;
        return super.equals(o);
    }
}
