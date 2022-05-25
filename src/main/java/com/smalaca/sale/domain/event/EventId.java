package com.smalaca.sale.domain.event;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class EventId {
    private final UUID id;
    private final UUID correlationId;
    private final LocalDateTime creationTime;

    private EventId(UUID id, UUID correlationId, LocalDateTime creationTime) {
        this.id = id;
        this.correlationId = correlationId;
        this.creationTime = creationTime;
    }

    public static EventId create() {
        return new EventId(UUID.randomUUID(), UUID.randomUUID(), LocalDateTime.now());
    }
}
