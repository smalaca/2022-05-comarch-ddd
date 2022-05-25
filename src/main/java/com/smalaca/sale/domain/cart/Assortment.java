package com.smalaca.sale.domain.cart;

class Assortment {
    private final Amount amount;

    Assortment(Amount amount) {
        this.amount = amount;
    }

    boolean hasNotEnough(Amount amount) {
        return this.amount.isLowerThan(amount);
    }
}
