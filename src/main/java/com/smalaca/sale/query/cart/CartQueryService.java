package com.smalaca.sale.query.cart;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartQueryService {
    private final SpringDataCartReadModelRepository repository;

    CartQueryService(SpringDataCartReadModelRepository repository) {
        this.repository = repository;
    }

    public CartDataModel findOneBy(UUID buyerId) {
        return null;
    }
}
