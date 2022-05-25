package com.smalaca.sale.domain.offer;

import com.smalaca.sale.domain.cart.Buyer;

import java.util.List;

class OfferException extends RuntimeException {
    OfferException(Buyer buyer, List<OfferItem> offerItems) {
    }
}
