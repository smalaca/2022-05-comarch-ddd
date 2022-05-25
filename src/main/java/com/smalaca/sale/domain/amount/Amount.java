package com.smalaca.sale.domain.amount;

public class Amount {
    private final int amount;

    private Amount(int amount) {
        this.amount = amount;
    }

    public static Amount create(int amount) {
        if (amount > 0) {
            return new Amount(amount);
        } else {
            throw new InvalidAmountException(amount);
        }
    }

    public int get() {
        return amount;
    }

    public boolean isLowerThan(Amount amount) {
        return this.amount < amount.amount;
    }
}
