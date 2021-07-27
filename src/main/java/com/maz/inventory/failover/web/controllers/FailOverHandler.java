package com.maz.inventory.failover.web.controllers;

import com.maz.inventory.failover.web.models.BeerInventoryDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import java.time.OffsetDateTime;
import java.util.UUID;

@Component
public class FailOverHandler {

    public Mono<ServerResponse> getFailOverBeerInventory(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(Mono.just(BeerInventoryDto.builder()
                .id(UUID.randomUUID())
                .beerId(UUID.fromString("00000000-0000-0000-0000-000000000000")).quantityOnHand(9999)
                 .createdDate(OffsetDateTime.now())
                 .lastModifiedDate(OffsetDateTime.now())
                .build()), BeerInventoryDto.class);
    }

}
