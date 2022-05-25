package com.smalaca.sale.application.cart;

import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
public class AcceptCartDto {

  String buyerFirstName;
  String buyerLastName;

  List<UUID> productIds;

  UUID buyerId;
}
