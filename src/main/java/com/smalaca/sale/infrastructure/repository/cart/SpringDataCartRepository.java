package com.smalaca.sale.infrastructure.repository.cart;

import com.smalaca.sale.domain.cart.BuyerId;
import com.smalaca.sale.domain.cart.Cart;
import org.springframework.data.repository.CrudRepository;

interface SpringDataCartRepository extends CrudRepository<Cart, BuyerId> {
}
