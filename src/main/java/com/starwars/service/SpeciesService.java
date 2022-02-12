package com.starwars.service;

import com.starwars.model.Planet;
import com.starwars.model.Species;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class SpeciesService {

    private final WebClient builder;

    public SpeciesService(WebClient builder) {
        this.builder = builder;
    }

    public Flux<Species.Root> getSpecies(String search, String page) {
        return builder
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/species/")
                        .queryParam("page", page)
                        .queryParam("search", search)
                        .build())
                .retrieve()
                .bodyToFlux(Species.Root.class);
    }

    public Flux<Species> getSpeciesById(String id) {
        return builder
                .get()
                .uri("/species/" + id + "/")
                .retrieve()
                .bodyToFlux(Species.class);
    }

}
