package com.starwars.service;

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

    public Flux<Person> getPeople(String search, String page, String format) {
        return builder
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/people/")
                        .queryParam("page", page)
                        .queryParam("search", search)
                        //.queryParam("format", format)
                        .build())
                .retrieve()
                .bodyToFlux(Person.Root.class)
                .flatMap(person -> Flux.fromStream(person.results.stream()));

    }

}
