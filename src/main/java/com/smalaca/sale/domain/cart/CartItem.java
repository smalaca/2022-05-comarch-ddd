package com.smalaca.sale.domain.cart;

import com.smalaca.sale.domain.amount.Amount;
import com.smalaca.sale.domain.product.ProductId;

class CartItem {
    private final ProductId productId;
    private final Amount amount;

    CartItem(ProductId productId, Amount amount) {
        this.productId = productId;
        this.amount = amount;
    }

    Assortment toAssortment() {
        return new Assortment(productId, amount);
    }

    boolean isFor(ProductId productId) {
        return this.productId.equals(productId);
    }

    ProductId getProductId() {
        return productId;
    }

    Amount getAmount() {
        return amount;
    }
}
