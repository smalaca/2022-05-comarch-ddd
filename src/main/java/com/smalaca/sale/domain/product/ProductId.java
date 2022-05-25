package com.smalaca.sale.domain.product;

import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode
public class ProductId {
    private final UUID productId;

    private ProductId(UUID productId) {
        this.productId = productId;
    }

    public static ProductId create(UUID productId) {
        return new ProductId(productId);
    }
}
