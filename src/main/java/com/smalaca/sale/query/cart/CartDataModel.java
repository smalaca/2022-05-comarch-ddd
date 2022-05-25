package com.smalaca.sale.query.cart;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "CARTS")
@Getter
public class CartDataModel {
    @Id
    private UUID buyerId;
    @OneToMany
    private List<CartItemDataModel> cartItemDataModels;
}
