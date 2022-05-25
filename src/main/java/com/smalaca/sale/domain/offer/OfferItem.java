package com.smalaca.sale.domain.offer;

import com.smalaca.sale.domain.amount.Amount;
import com.smalaca.price.Price;
import com.smalaca.sale.domain.product.ProductId;
import com.smalaca.sale.domain.seller.Seller;

class OfferItem {
    private final ProductId productId;
    private final Seller seller;
    private final Price price;
    private final Amount amount;

    OfferItem(ProductId productId, Seller seller, Price price, Amount amount) {
        this.productId = productId;
        this.seller = seller;
        this.price = price;
        this.amount = amount;
    }

    Price calculateCost() {
        return price.multiply(amount);
    }
}
