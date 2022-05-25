package com.smalaca.sale.domain.offer;

import com.smalaca.sale.domain.cart.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Offer {

    private final Buyer buyer;
    private final List<OfferItem> offerItems;
    private final Price cost;

    private Offer(Buyer buyer, List<OfferItem> offerItems, Price cost) {
        this.buyer = buyer;
        this.offerItems = offerItems;
        this.cost = cost;
    }

    public static Offer create(Buyer buyer, List<Product> products) {

        Map<ProductId, Product> productMap = products.stream().collect(Collectors.toMap(Product::getProductId, Function.identity()));

        List<OfferItem> offerItems = productMap.keySet().stream().map(productId ->
                new OfferItem(productMap.get(productId), productMap.get(productId).getAmount())).collect(Collectors.toList());

        Price cost = calculatePrice(offerItems);
        return new Offer(buyer, offerItems, cost);
    }

    private static Price calculatePrice(List<OfferItem> offerItems) {
        return offerItems.stream()
                .map(OfferItem::calculateCost)
                .reduce(Price.ZERO, Price::add);
    }
}
