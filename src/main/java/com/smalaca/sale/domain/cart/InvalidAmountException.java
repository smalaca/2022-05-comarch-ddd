package com.smalaca.sale.domain.cart;

class InvalidAmountException extends RuntimeException {
    private final int amount;

    InvalidAmountException(int amount) {
        this.amount = amount;
    }
}
