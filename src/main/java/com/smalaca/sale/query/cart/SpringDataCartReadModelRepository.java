package com.smalaca.sale.query.cart;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface SpringDataCartReadModelRepository extends CrudRepository<CartDataModel, UUID> {
}
