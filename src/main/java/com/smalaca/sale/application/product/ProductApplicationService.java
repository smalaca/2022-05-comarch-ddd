package com.smalaca.sale.application.product;

import com.smalaca.sale.domain.cart.OfferCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ProductApplicationService {
    @EventListener
    public void unavailable(OfferCreatedEvent event) {

    }
}
