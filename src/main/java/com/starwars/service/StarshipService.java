package com.starwars.service;


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

    public Flux<Starship> getStarships(String search, String page, String format) {
        return builder
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/starships/")
                        .queryParam("page", page)
                        .queryParam("search", search)
                        //.queryParam("format", format)
                        .build())
                .retrieve()
                .bodyToFlux(Starship.Root.class)
                .flatMap(person -> Flux.fromStream(person.results.stream()));

    }
}
