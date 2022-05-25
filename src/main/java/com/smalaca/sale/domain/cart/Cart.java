package com.smalaca.sale.domain.cart;

import com.smalaca.sale.domain.amount.Amount;
import com.smalaca.sale.domain.buyer.Buyer;
import com.smalaca.sale.domain.offer.Offer;
import com.smalaca.sale.domain.product.ProductId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Entity
public class Cart {
    @EmbeddedId
    private BuyerId buyerId;
    @OneToMany
    private List<CartItem> items = new ArrayList<>();

    private Cart() {}

    Cart(BuyerId buyerId) {
        this.buyerId = buyerId;
    }

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
            Offer offer = create(buyer, products);
            items.removeIf(item -> productIds.contains(item.getProductId()));
            return offer;
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
        Offer.Builder builder = new Offer.Builder(buyer);

        products.forEach(product -> {
            builder.addItem(product.getProductId(), product.getSeller(), product.getPrice(), amountFor(product.getProductId()));
        });

        return builder.build();
    }

    private Amount amountFor(ProductId productId) {
        return items.stream()
                .filter(item -> item.isFor(productId))
                .findFirst().get()
                .getAmount();
    }

    private boolean hasNotAll(List<ProductId> productIds) {
        List<CartItem> accepted = getCartItemsFor(productIds);

        return accepted.size() == productIds.size();
    }

    private List<CartItem> getCartItemsFor(List<ProductId> productIds) {
        return items.stream()
                .filter(item -> productIds.contains(item.getProductId()))
                .collect(toList());
    }


}
