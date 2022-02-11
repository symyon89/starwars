package com.starwars.service;

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

    public Flux<Species> getSpecies(String search, String page, String format) {
        return builder
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/species/")
                        .queryParam("page", page)
                        .queryParam("search", search)
                        //.queryParam("format", format)
                        .build())
                .retrieve()
                .bodyToFlux(Species.Root.class)
                .flatMap(person -> Flux.fromStream(person.results.stream()));

    }

}
