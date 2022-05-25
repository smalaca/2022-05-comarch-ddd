package com.smalaca.sale.domain.cart;

import java.math.BigDecimal;

public class Price {
    private final BigDecimal value;

    Price(BigDecimal value) {
        this.value = value;
    }
}
