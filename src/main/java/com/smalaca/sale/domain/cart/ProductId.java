package com.smalaca.sale.domain.cart;

import java.util.UUID;

public class ProductId {
    private final UUID productId;

    private ProductId(UUID productId) {
        this.productId = productId;
    }

    public static ProductId create(UUID productId) {
        return new ProductId(productId);
    }
}
