package com.smalaca.sale.query.cart;

import lombok.Getter;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Getter
public class CartItemDataModel {
    private UUID productId;
    private int amount;
}
