package com.starwars.service;

import com.starwars.model.Starship;
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

    public Flux<Vehicle.Root> getVehicles(String search, String page) {
        return builder
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/vehicles/")
                        .queryParam("page", page)
                        .queryParam("search", search)
                        .build())
                .retrieve()
                .bodyToFlux(Vehicle.Root.class);
    }
    public Flux<Vehicle> getVehicleById(String id) {
        return builder
                .get()
                .uri("/vehicles/" + id + "/")
                .retrieve()
                .bodyToFlux(Vehicle.class);
    }
}
