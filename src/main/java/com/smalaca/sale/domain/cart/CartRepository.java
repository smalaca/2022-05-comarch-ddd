package com.smalaca.sale.domain.cart;

public interface CartRepository {
    Cart findFor(BuyerId buyerId);

    void save(Cart cart);
}
