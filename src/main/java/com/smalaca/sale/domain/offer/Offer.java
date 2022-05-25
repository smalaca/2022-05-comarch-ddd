package com.smalaca.sale.domain.offer;

import com.smalaca.sale.domain.cart.Buyer;
import com.smalaca.sale.domain.cart.Price;

import java.util.List;

public class Offer {

    private final Buyer buyer;
    private final List<OfferItem> offerItems;
    private final Price cost;

    public Offer(Buyer buyer, List<OfferItem> offerItems, Price cost) {
        this.buyer = buyer;
        this.offerItems = offerItems;
        this.cost = cost;
    }
}
