package com.starwars.service;

import com.starwars.exceptions.PageNotFoundException;
import com.starwars.exceptions.ServerException;
import com.starwars.model.Film;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
                .onStatus(HttpStatus::is5xxServerError,clientResponse ->  Mono.error(new ServerException("Error 500")))
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->  Mono.error(new PageNotFoundException("Error 400")))
                .bodyToFlux(Film.Root.class);
    }

    public Flux<Film> getFilmById(String id)  {
        return builder
                .get()
                .uri("/films/" + id + "/")
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError,clientResponse ->  Mono.error(new ServerException("Error 500")))
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->  Mono.error(new PageNotFoundException("Error 400")))
                .bodyToFlux(Film.class);
    }


}
