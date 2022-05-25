package com.smalaca.sale.domain.offer;

import com.smalaca.sale.domain.cart.Amount;
import com.smalaca.sale.domain.cart.Buyer;
import com.smalaca.sale.domain.cart.Price;
import com.smalaca.sale.domain.cart.ProductId;
import com.smalaca.sale.domain.cart.Seller;

import java.util.ArrayList;
import java.util.List;

public class Offer {
    private final Buyer buyer;
    private final List<OfferItem> offerItems;
    private final Price cost;

    private Offer(Buyer buyer, List<OfferItem> offerItems, Price cost) {
        this.buyer = buyer;
        this.offerItems = offerItems;
        this.cost = cost;
    }

    public static class Builder {
        private final List<OfferItem> offerItems = new ArrayList<>();
        private final Buyer buyer;

        public Builder(Buyer buyer) {
            this.buyer = buyer;
        }

        public Offer build() {
            if (buyer == null || offerItems.isEmpty()) {
                throw new OfferException(buyer, offerItems);
            }

            return new Offer(buyer, offerItems, cost());
        }

        private Price cost() {
            return offerItems.stream()
                    .map(OfferItem::calculateCost)
                    .reduce(Price.ZERO, Price::add);
        }

        public void addItem(ProductId productId, Seller seller, Price price, Amount amount) {
            OfferItem offerItem = new OfferItem(productId, seller, price, amount);
            offerItems.add(offerItem);
        }
    }
}
