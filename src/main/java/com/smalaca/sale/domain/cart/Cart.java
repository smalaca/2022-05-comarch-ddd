package com.smalaca.sale.domain.cart;

import com.smalaca.sale.domain.offer.Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public void addProduct(Warehouse warehouse, ProductId productId, Amount amount) {
      checkProductAvailable(warehouse, productId, amount);

      items.add(new CartItem(productId, amount));
    }

  private void checkProductAvailable(Warehouse warehouse, ProductId productId, Amount amount) {
    Optional<Assortment> assortment = warehouse.findAssortmentFor(productId);

    if (assortment.isEmpty()) {
        throw AssortmentException.doesNotExist(productId);
    }

    if (assortment.get().hasNotEnough(amount)) {
        throw AssortmentException.hasNotEnoughProducts(productId, amount);
    }
  }

  private void checkProductsAvailable(Warehouse warehouse, List<ProductId> productIds, Amount amount) {
    Optional<Assortment> assortment = warehouse.findAssortmentFor(productId);

    if (assortment.isEmpty()) {
        throw AssortmentException.doesNotExist(productId);
    }

    if (assortment.get().hasNotEnough(amount)) {
        throw AssortmentException.hasNotEnoughProducts(productId, amount);
    }
  }

  public Offer accept(Buyer buyer, List<ProductId> productIds) {
      if (hasNotAll(productIds)) {
        throw CartException.hasNotAll(productIds);
      }

      checkProductAvailable(warehouse, );
      
      return null;
    }

  private boolean hasNotAll(List<ProductId> productIds) {
    return false;
  }
}
