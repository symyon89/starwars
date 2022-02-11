package com.starwars.service;

import com.starwars.model.Vehicle;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class VehicleService {
    private final WebClient builder;

    public VehicleService(WebClient builder) {
        this.builder = builder;
    }

    public Flux<Vehicle> getVehicles(String search, String page, String format) {
        return builder
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/starships/")
                        .queryParam("page", page)
                        .queryParam("search", search)
                        //.queryParam("format", format)
                        .build())
                .retrieve()
                .bodyToFlux(Vehicle.Root.class)
                .flatMap(person -> Flux.fromStream(person.results.stream()));
    }
}
