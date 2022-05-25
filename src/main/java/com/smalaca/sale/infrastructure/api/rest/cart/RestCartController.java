package com.smalaca.sale.infrastructure.api.rest.cart;

import com.smalaca.sale.application.cart.CartApplicationService;
import com.smalaca.sale.query.cart.CartQueryService;
import com.smalaca.sale.query.cart.CartDataModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("cart")
public class RestCartController {
    private final CartApplicationService cartApplicationService;
    private final CartQueryService cartQueryService;

    RestCartController(CartApplicationService cartApplicationService, CartQueryService cartQueryService) {
        this.cartApplicationService = cartApplicationService;
        this.cartQueryService = cartQueryService;
    }

    @GetMapping
    public CartDataModel findOne() {
        return cartQueryService.findOneBy(buyerId());
    }

    @PostMapping("/accept")
    public void accept(@Valid @RequestBody CartDto dto) {
        cartApplicationService.accept(dto.asAcceptCartDto(buyerId()));
    }

    private UUID buyerId() {
        return null;
    }
}
