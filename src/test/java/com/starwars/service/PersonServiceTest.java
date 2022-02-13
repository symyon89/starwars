package com.starwars.service;

import com.starwars.model.Film;
import com.starwars.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {


    @Test
    void getPeopleTest_returns_body() {
        WebTestClient.bindToServer()
                .baseUrl("https://swapi.dev/api/")
                .build()
                .get()
                .uri("/people")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Person.Root.class).hasSize(1);
    }

    @Test
    void getPersonByIdTest_returns_body() {
        WebTestClient.bindToServer()
                .baseUrl("https://swapi.dev/api/")
                .build()
                .get()
                .uri("/people/1")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Person.class).hasSize(1);
    }
}