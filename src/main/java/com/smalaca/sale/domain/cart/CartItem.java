package com.smalaca.sale.domain.cart;

class CartItem {
    private final ProductId productId;
    private final Amount amount;

    CartItem(ProductId productId, Amount amount) {
        this.productId = productId;
        this.amount = amount;
    }
}
