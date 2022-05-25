package com.smalaca.sale.domain.offer;

import com.smalaca.sale.domain.cart.Amount;
import com.smalaca.sale.domain.cart.Price;
import com.smalaca.sale.domain.cart.ProductId;
import com.smalaca.sale.domain.cart.Seller;

public class OfferItem {
    private final ProductId productId;
    private final Seller seller;
    private final Price price;
    private final Amount amount;

    public OfferItem(ProductId productId, Seller seller, Price price, Amount amount) {
        this.productId = productId;
        this.seller = seller;
        this.price = price;
        this.amount = amount;
    }

    public Price calculateCost() {
        return price.multiply(amount);
    }
}
