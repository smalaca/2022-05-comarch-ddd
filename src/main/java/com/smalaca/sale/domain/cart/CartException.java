package com.smalaca.sale.domain.cart;

import com.smalaca.sale.domain.product.ProductId;

import java.util.List;

class CartException extends RuntimeException {
    static RuntimeException hasNotAll(List<ProductId> productIds) {
        return null;
    }
}
