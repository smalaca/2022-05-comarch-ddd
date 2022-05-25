package com.smalaca.sale.domain.event;

import com.smalaca.sale.domain.cart.OfferCreatedEvent;

public interface EventRegistry {
    void publish(OfferCreatedEvent offerCreatedEvent);
}
