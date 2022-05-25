package com.smalaca.sale.domain.cart;

import com.smalaca.sale.domain.event.EventId;
import com.smalaca.sale.domain.product.ProductId;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Getter
public class OfferCreatedEvent {
    private final EventId eventId;
    private final List<UUID> productIds;

    private OfferCreatedEvent(EventId eventId, List<UUID> productIds) {
        this.eventId = eventId;
        this.productIds = productIds;
    }

    static OfferCreatedEvent create(List<ProductId> productIds) {
        return new OfferCreatedEvent(EventId.create(), asUUID(productIds));
    }

    private static List<UUID> asUUID(List<ProductId> productIds) {
        return productIds.stream().map(ProductId::get).collect(toList());
    }
}
