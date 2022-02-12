package com.starwars.service;


import com.starwars.model.Species;
import com.starwars.model.Starship;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class StarshipService {
    private final WebClient builder;

    public StarshipService(WebClient builder) {
        this.builder = builder;
    }

    public Flux<Starship.Root> getStarships(String search, String page) {
        return builder
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/starships/")
                        .queryParam("page", page)
                        .queryParam("search", search)
                        .build())
                .retrieve()
                .bodyToFlux(Starship.Root.class);

    }

    public Flux<Starship> getStarshipById(String id) {
        return builder
                .get()
                .uri("/starships/" + id + "/")
                .retrieve()
                .bodyToFlux(Starship.class);
    }
}
