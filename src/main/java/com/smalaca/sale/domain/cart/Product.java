package com.smalaca.sale.domain.cart;

import lombok.Getter;

public class Product {
    @Getter
    private final ProductId productId;
    private final Seller seller;
    @Getter
    private final Price price;
    @Getter
    private final Amount amount;

    Product(ProductId productId, Seller seller, Price price, Amount amount) {
        this.productId = productId;
        this.seller = seller;
        this.price = price;
        this.amount = amount;
    }
}
