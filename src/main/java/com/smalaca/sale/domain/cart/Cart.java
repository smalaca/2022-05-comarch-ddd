package com.smalaca.sale.domain.cart;

import com.smalaca.sale.domain.offer.Offer;
import com.smalaca.sale.domain.offer.OfferItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public void addProduct(Warehouse warehouse, ProductId productId, Amount amount) {
        Optional<Assortment> assortment = warehouse.findAssortmentFor(productId);

        if (assortment.isEmpty()) {
            throw AssortmentException.doesNotExist(productId);
        }

        if (assortment.get().hasNotEnough(amount)) {
            throw AssortmentException.hasNotEnoughProducts(productId, amount);
        }

        items.add(new CartItem(productId, amount));
    }

    public Offer accept(Warehouse warehouse, Buyer buyer, List<ProductId> productIds) {
        if (hasNotAll(productIds)) {
            throw CartException.hasNotAll(productIds);
        }

        List<Assortment> assortments = asAssortments(productIds);

        if (warehouse.areAvailable(assortments)) {
            List<Product> products = warehouse.findProducts(productIds);
            return create(buyer, products);
        } else {
            throw AssortmentException.notAvailable(assortments);
        }
    }

    private List<Assortment> asAssortments(List<ProductId> productIds) {
        return items.stream()
                .filter(item -> productIds.contains(item.getProductId()))
                .map(CartItem::toAssortment)
                .collect(toList());
    }

    private Offer create(Buyer buyer, List<Product> products) {
        List<OfferItem> offerItems = products.stream()
                .map(this::asOfferItem)
                .collect(toList());

        Price cost = calculatePrice(offerItems);
        return new Offer(buyer, offerItems, cost);
    }

    private OfferItem asOfferItem(Product product) {
        return new OfferItem(product.getProductId(), product.getSeller(), product.getPrice(), amountFor(product.getProductId()));
    }

    private Price calculatePrice(List<OfferItem> offerItems) {
        return offerItems.stream()
                .map(OfferItem::calculateCost)
                .reduce(Price.ZERO, Price::add);
    }

    private Amount amountFor(ProductId productId) {
        return items.stream()
                .filter(item -> item.isFor(productId))
                .findFirst().get()
                .getAmount();
    }

    private boolean hasNotAll(List<ProductId> productIds) {
        List<CartItem> accepted = items.stream()
                .filter(item -> productIds.contains(item.getProductId()))
                .collect(toList());

        return accepted.size() == productIds.size();
    }
}
