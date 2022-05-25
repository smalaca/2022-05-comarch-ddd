package com.smalaca.sale.domain.cart;

import com.smalaca.sale.domain.offer.Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
      List<Assortment> assortments = items.stream().filter(item -> productIds.contains(item.getProductId()))
              .map(CartItem::toAssortment).collect(Collectors.toList());
      if (warehouse.areAvailable(assortments)){
          List<Product> products=  warehouse.findProducts(productIds);
          return Offer.create(buyer, products, assortments);
      } else {
          throw AssortmentException.notAvailable(assortments);
      }
    }

  private boolean hasNotAll(List<ProductId> productIds) {
    return false;
  }
}
