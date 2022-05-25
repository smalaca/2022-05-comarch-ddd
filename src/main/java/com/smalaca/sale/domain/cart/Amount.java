package com.smalaca.sale.domain.cart;

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

    int get() {
        return amount;
    }

    boolean isLowerThan(Amount amount) {
        return this.amount < amount.amount;
    }
}
