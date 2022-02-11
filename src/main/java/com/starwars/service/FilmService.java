package com.starwars.service;

import com.starwars.model.Film;
import com.starwars.model.Root;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
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

    public Flux<Root> getFilms(int startPage, int rowsPerPage, String search) {
        var result = builder
                .get()
                .uri("/films?search=" + search)
                .retrieve()
                .bodyToFlux(Root.class);
        if (rowsPerPage > 0) {
            return Flux.fromIterable(result.collectList().block().stream().skip(startPage*rowsPerPage).limit(rowsPerPage).toList());
        }
        return result;
    }
//    public Mono<List<Root>> dosomething() {
//        for (Root root : this.getFilms().block()) {
//            System.out.println(root.results);
//            System.out.println();
//        }
//        return getFilms();
//
//    }

}
