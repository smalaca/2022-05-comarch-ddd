package com.smalaca.sale.infrastructure.eventregistry.inmemory;

import com.smalaca.sale.domain.cart.OfferCreatedEvent;
import com.smalaca.sale.domain.event.EventRegistry;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class InMemoryEventRegistry implements EventRegistry {
    private final ApplicationEventPublisher applicationEventPublisher;

    InMemoryEventRegistry(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void publish(OfferCreatedEvent offerCreatedEvent) {
        applicationEventPublisher.publishEvent(offerCreatedEvent);
    }
}
