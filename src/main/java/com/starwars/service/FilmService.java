package com.starwars.service;

import com.starwars.model.Root;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class FilmService {

    private final WebClient builder;

    public FilmService(WebClient.Builder builder) {
        this.builder = builder
                .baseUrl("https://swapi.dev/api/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Flux<Root> getFilms(String search, String page) {
        return builder
                .get()
                .uri(createUri(search,page))
                .retrieve()
                .bodyToFlux(Root.class);
    }

    private String createUri(String search, String page) {
        String result = "/films";
        if (search != null && page == null) {
            result = "/films/?search=" + search;
        } else if (search == null && page != null) {
            result = "/films/?page=" + page;
        } else if (search != null && page != null) {
            result = "/films/?search=" + search + "&page=" + page;
        }
        return result;
    }


}
