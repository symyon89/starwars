package com.starwars.service;

import com.starwars.model.Person;
import com.starwars.model.Planet;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class PlanetService {
    private final WebClient builder;

    public PlanetService(WebClient builder) {
        this.builder = builder;
    }

    public Flux<Planet.Root> getPlanets(String search, String page) {
        return builder
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/planets/")
                        .queryParam("page", page)
                        .queryParam("search", search)
                        .build())
                .retrieve()
                .bodyToFlux(Planet.Root.class);
    }

    public Flux<Planet> getPlanetById(String id) {
        return builder
                .get()
                .uri("/planets/" + id + "/")
                .retrieve()
                .bodyToFlux(Planet.class);
    }
}
