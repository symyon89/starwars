package com.starwars.service;

import com.starwars.model.Film;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class FilmService {

    private final WebClient builder;

    public FilmService(WebClient.Builder builder) {
        this.builder = builder
                .baseUrl("https://swapi.dev/api/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Mono<List<Film>> getFilms() {
        return  builder
                .get()
                .uri("/films")
                .retrieve()
                .bodyToFlux(Film.class)
                .collectList();
    }
    public Mono<List<Film>> dosomething() {
        for (Film film : this.getFilms().block()) {
            System.out.println(film.getAdditionalProperties());
            System.out.println();
        }
        return getFilms();

    }

}
