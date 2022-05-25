package com.smalaca.sale.application.cart;

import com.smalaca.sale.domain.cart.Amount;
import com.smalaca.sale.domain.cart.BuyerId;
import com.smalaca.sale.domain.cart.Cart;
import com.smalaca.sale.domain.cart.CartRepository;
import com.smalaca.sale.domain.cart.ProductId;
import com.smalaca.sale.domain.cart.Warehouse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CartApplicationService {
    private final CartRepository repository;
    private final Warehouse warehouse;

    public CartApplicationService(CartRepository repository, Warehouse warehouse) {
        this.repository = repository;
        this.warehouse = warehouse;
    }

    @Transactional
    public void addProduct(UUID buyerId, UUID productId, int amount) {
        BuyerId buyerIdVO = BuyerId.create(buyerId);
        Cart cart = repository.findFor(buyerIdVO);
        Amount amountVO = Amount.create(amount);
        ProductId productIdVO = ProductId.create(productId);

        cart.addProduct(warehouse, productIdVO, amountVO);

        repository.save(cart);
    }
}
