package com.starwars.service;

import com.starwars.model.Film;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class FilmService {

    private final WebClient builder;

    public FilmService(WebClient builder) {
        this.builder = builder;
    }


    public Flux<Film.Root> getFilms(String search, String page) {
        return builder
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/films/")
                        .queryParam("page", page)
                        .queryParam("search", search)
                        .build())
                .retrieve()
                .bodyToFlux(Film.Root.class);
    }

    public Flux<Film> getFilmById(String id) {
        return builder
                .get()
                .uri("/films/" + id + "/")
                .retrieve()
                .bodyToFlux(Film.class);
    }


}
