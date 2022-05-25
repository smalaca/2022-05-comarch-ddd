package com.smalaca.sale.domain.cart;

import java.util.Optional;

public interface Warehouse {
    Optional<Assortment> findAssortmentFor(ProductId productId);
}
