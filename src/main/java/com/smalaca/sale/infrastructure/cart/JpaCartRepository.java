package com.smalaca.sale.infrastructure.cart;

import com.smalaca.sale.domain.cart.BuyerId;
import com.smalaca.sale.domain.cart.Cart;
import com.smalaca.sale.domain.cart.CartRepository;
import org.springframework.stereotype.Repository;

@Repository
class JpaCartRepository implements CartRepository {
    private final SpringDataCartRepository repository;

    JpaCartRepository(SpringDataCartRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cart findFor(BuyerId buyerId) {
        return repository.findById(buyerId).get();
    }

    @Override
    public void save(Cart cart) {
        repository.save(cart);
    }
}
