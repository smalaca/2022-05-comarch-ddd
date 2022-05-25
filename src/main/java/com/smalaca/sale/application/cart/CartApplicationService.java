package com.smalaca.sale.application.cart;

import com.smalaca.sale.domain.amount.Amount;
import com.smalaca.sale.domain.buyer.Buyer;
import com.smalaca.sale.domain.cart.*;
import com.smalaca.sale.domain.event.EventRegistry;
import com.smalaca.sale.domain.offer.Offer;
import com.smalaca.sale.domain.offer.OfferRepository;
import com.smalaca.sale.domain.product.ProductId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CartApplicationService {
    private final CartRepository cartRepository;
    private final OfferRepository offerRepository;
    private final Warehouse warehouse;
    private final EventRegistry eventRegistry;

    public CartApplicationService(CartRepository cartRepository, OfferRepository offerRepository, Warehouse warehouse, EventRegistry eventRegistry) {
        this.cartRepository = cartRepository;
        this.offerRepository = offerRepository;
        this.warehouse = warehouse;
        this.eventRegistry = eventRegistry;
    }

    @Transactional
    public void addProduct(UUID buyerId, UUID productId, int amount) {
        BuyerId buyerIdVO = BuyerId.create(buyerId);
        Cart cart = cartRepository.findFor(buyerIdVO);
        Amount amountVO = Amount.create(amount);
        ProductId productIdVO = ProductId.create(productId);

        cart.addProduct(warehouse, productIdVO, amountVO);

        cartRepository.save(cart);
    }

    @Transactional
    public void accept(AcceptCartDto acceptCartDto){
        BuyerId buyerIdVO = BuyerId.create(acceptCartDto.getBuyerId());
        Cart cart = cartRepository.findFor(buyerIdVO);
        Buyer buyer = new Buyer(acceptCartDto.getBuyerFirstName(), acceptCartDto.getBuyerLastName());
        List<ProductId> productIds = acceptCartDto.getProductIds().stream().map(ProductId::create).collect(Collectors.toList());

        Offer offer = cart.accept(eventRegistry, warehouse, buyer,  productIds);

        cartRepository.save(cart);
        offerRepository.save(offer);
    }
}
