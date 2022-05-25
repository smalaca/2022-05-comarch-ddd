package com.smalaca.sale.domain.cart;

import java.math.BigDecimal;

public class Price {
    public static final Price ZERO = new Price(BigDecimal.ZERO);

    private final BigDecimal value;

    Price(BigDecimal value) {
        this.value = value;
    }

    public Price multiply(Amount amount) {
        return new Price(value.multiply(BigDecimal.valueOf(amount.get())));
    }

    Price add(Price price) {
        return new Price(value.add(price.value));
    }
}
