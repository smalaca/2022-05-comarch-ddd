package com.smalaca.sale.domain.cart;

import com.smalaca.sale.domain.amount.Amount;
import com.smalaca.sale.domain.product.ProductId;

class Assortment {
    private final ProductId productId;
    private final Amount amount;

    Assortment(ProductId productId, Amount amount) {
        this.productId = productId;
        this.amount = amount;
    }

    boolean hasNotEnough(Amount amount) {
        return this.amount.isLowerThan(amount);
    }
}
