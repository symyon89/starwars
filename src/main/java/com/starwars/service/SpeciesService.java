package com.starwars.service;

import com.starwars.exceptions.PageNotFoundException;
import com.starwars.exceptions.ServerException;
import com.starwars.model.Planet;
import com.starwars.model.Species;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
                .onStatus(HttpStatus::is5xxServerError, clientResponse ->  Mono.just(new ServerException("Error 500")))
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->  Mono.just(new PageNotFoundException("Error 400")))
                .bodyToFlux(Species.class);
    }

}
