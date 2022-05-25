package com.smalaca.sale.domain.offer;

import java.math.BigDecimal;

import com.smalaca.sale.domain.cart.Amount;
import com.smalaca.sale.domain.cart.Price;
import com.smalaca.sale.domain.cart.Product;

class OfferItem {

    private final Product product;
    private final Amount amount;

    public OfferItem(Product product, Amount amount) {
        this.product = product;
        this.amount = amount;
    }

    public Price calculateCost() {
        return product.getPrice().multiply(amount);
    }
}
