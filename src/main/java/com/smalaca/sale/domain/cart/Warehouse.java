package com.smalaca.sale.domain.cart;

import com.smalaca.sale.domain.product.ProductId;

import java.util.List;
import java.util.Optional;

public interface Warehouse {
    Optional<Assortment> findAssortmentFor(ProductId productId);

    boolean areAvailable(List<Assortment> assortments);

    List<Product> findProducts(List<ProductId> productIds);
}
