package com.starwars.service;

import com.starwars.model.Film;
import com.starwars.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

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
                .bodyToFlux(Person.Root.class);

    }

    public Flux<Person> getPersonById(String id) {
        return builder
                .get()
                .uri("/people/" + id + "/")
                .retrieve()
                .bodyToFlux(Person.class);
    }
}
