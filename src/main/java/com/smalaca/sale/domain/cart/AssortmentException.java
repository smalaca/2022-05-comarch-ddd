package com.smalaca.sale.domain.cart;

import java.util.List;

class AssortmentException {
    static RuntimeException doesNotExist(ProductId productId) {
        return new RuntimeException("Product does not exist: " + productId);
    }

    static RuntimeException hasNotEnoughProducts(ProductId productId, Amount amount) {
        return new RuntimeException("Has not enough product: " + productId + ". Expected amount " + amount.get());
    }

    public static RuntimeException notAvailable(List<Assortment> assortments) {
        return null;
    }
}
