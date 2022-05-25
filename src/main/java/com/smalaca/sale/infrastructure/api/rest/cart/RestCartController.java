package com.smalaca.sale.infrastructure.api.rest.cart;

import com.smalaca.sale.application.cart.CartApplicationService;
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

    RestCartController(CartApplicationService cartApplicationService) {
        this.cartApplicationService = cartApplicationService;
    }

    @PostMapping("/accept")
    public void accept(@Valid @RequestBody CartDto dto) {
        cartApplicationService.accept(dto.asAcceptCartDto(buyerId()));
    }

    private UUID buyerId() {
        return null;
    }
}
