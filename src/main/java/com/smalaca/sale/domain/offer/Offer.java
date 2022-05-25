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

    public static Offer create(Buyer buyer, List<Product> products, List<Assortment> assortments) {

        Map<ProductId, Product> productMap = products.stream().collect(Collectors.toMap(Product::getProductId, Function.identity()));
        Map<ProductId, Assortment> assortmentsMap = assortments.stream().collect(Collectors.toMap(Assortment::getProductId, Function.identity()));

        List<OfferItem> offerItems = productMap.keySet().stream().map(productId ->
                new OfferItem(productMap.get(productId), assortmentsMap.get(productId).getAmount())).collect(Collectors.toList());

        return new Offer(buyer, offerItems, null);
    }
}
