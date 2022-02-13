package com.starwars.service;

import com.starwars.exceptions.PageNotFoundException;
import com.starwars.exceptions.ServerException;
import com.starwars.model.Person;
import com.starwars.model.Planet;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
                .onStatus(HttpStatus::is5xxServerError, clientResponse ->  Mono.error(new ServerException("Error 500")))
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->  Mono.error(new PageNotFoundException("Error 400")))
                .bodyToFlux(Planet.Root.class);
    }

    public Flux<Planet> getPlanetById(String id) {
        return builder
                .get()
                .uri("/planets/" + id + "/")
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError, clientResponse ->  Mono.error(new ServerException("Error 500")))
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->  Mono.error(new PageNotFoundException("Error 400")))
                .bodyToFlux(Planet.class);
    }
}
