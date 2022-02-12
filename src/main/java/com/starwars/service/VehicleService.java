package com.starwars.service;

import com.starwars.exceptions.PageNotFoundException;
import com.starwars.exceptions.ServerException;
import com.starwars.model.Starship;
import com.starwars.model.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
                .onStatus(HttpStatus::is5xxServerError,clientResponse ->  Mono.just(new ServerException("Error 500")))
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->  Mono.just(new PageNotFoundException("Error 400")))
                .bodyToFlux(Vehicle.Root.class);
    }
    public Flux<Vehicle> getVehicleById(String id) {
        return builder
                .get()
                .uri("/vehicles/" + id + "/")
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError, clientResponse ->  Mono.just(new ServerException("Error 500")))
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->  Mono.just(new PageNotFoundException("Error 400")))
                .bodyToFlux(Vehicle.class);
    }
}
