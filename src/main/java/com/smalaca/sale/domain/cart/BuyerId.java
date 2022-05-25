package com.smalaca.sale.domain.cart;

import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public class BuyerId {
    private UUID buyerId;

    private BuyerId() {}

    private BuyerId(UUID buyerId) {
        this.buyerId = buyerId;
    }

    public static BuyerId create(UUID buyerId) {
        return new BuyerId(buyerId);
    }
}
