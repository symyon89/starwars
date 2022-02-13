package com.starwars.service;

import com.starwars.exceptions.PageNotFoundException;
import com.starwars.exceptions.ServerException;
import com.starwars.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService {

    private final WebClient builder;

    public PersonService(WebClient builder) {
        this.builder = builder;
    }

    public Flux<Person.Root> getPeople(String search, String page) {
        return builder
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/people/")
                        .queryParam("page", page)
                        .queryParam("search", search)
                        .build())

                .retrieve()
                .onStatus(HttpStatus::is5xxServerError,clientResponse ->  Mono.error(new ServerException("Error 500")))
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->  Mono.error(new PageNotFoundException("Error 400")))
                .bodyToFlux(Person.Root.class);

    }

    public Flux<Person> getPersonById(String id) {
        return builder
                .get()
                .uri("/people/" + id + "/")
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError,clientResponse ->  Mono.error(new ServerException("Error 500")))
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->  Mono.error(new PageNotFoundException("Error 400")))
                .bodyToFlux(Person.class);
    }
}
