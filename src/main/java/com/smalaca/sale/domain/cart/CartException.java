package com.smalaca.sale.domain.cart;

import java.util.List;

class CartException extends RuntimeException {
    static RuntimeException hasNotAll(List<ProductId> productIds) {
        return null;
    }
}
