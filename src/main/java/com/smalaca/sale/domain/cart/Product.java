package com.smalaca.sale.domain.cart;

import lombok.AccessLevel;
import lombok.Getter;

@Getter(AccessLevel.PACKAGE)
class Product {
    private final ProductId productId;
    private final Seller seller;
    private final Price price;

    Product(ProductId productId, Seller seller, Price price) {
        this.productId = productId;
        this.seller = seller;
        this.price = price;
    }
}
