package com.starwars.service;

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

    public Flux<Planet> getPlanets(String search, String page, String format) {
        return builder
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/planets/")
                        .queryParam("page", page)
                        .queryParam("search", search)
                        //.queryParam("format", format)
                        .build())
                .retrieve()
                .bodyToFlux(Planet.Root.class)
                .flatMap(person -> Flux.fromStream(person.results.stream()));

    }
}
