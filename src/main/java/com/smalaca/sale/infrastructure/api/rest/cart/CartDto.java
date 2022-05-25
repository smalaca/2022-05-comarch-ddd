package com.smalaca.sale.infrastructure.api.rest.cart;

import com.smalaca.sale.application.cart.AcceptCartDto;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class CartDto {
    @Pattern(regexp = "")
    private final String buyerFirstName;
    @Pattern(regexp = "")
    private final String buyerLastName;
    private final List<UUID> productIds;

    AcceptCartDto asAcceptCartDto(UUID buyerId) {
        return new AcceptCartDto(buyerFirstName, buyerLastName, productIds, buyerId);
    }
}
