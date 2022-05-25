package com.smalaca.sale.domain.cart;

import java.util.UUID;

public class BuyerId {
    private final UUID buyerId;

    private BuyerId(UUID buyerId) {
        this.buyerId = buyerId;
    }

    public static BuyerId create(UUID buyerId) {
        return new BuyerId(buyerId);
    }
}
