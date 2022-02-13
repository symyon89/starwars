package com.starwars.service;

import com.starwars.model.Person;
import com.starwars.model.Planet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

class PlanetServiceTest {

    @Test
    void getPlanetsTest_returns_body() {
        WebTestClient.bindToServer()
                .baseUrl("https://swapi.dev/api/")
                .build()
                .get()
                .uri("/planets")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Planet.Root.class).hasSize(1);
    }

    @Test
    void getPlanetByIdTest_returns_body() {
        WebTestClient.bindToServer()
                .baseUrl("https://swapi.dev/api/")
                .build()
                .get()
                .uri("/planets/1")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Planet.class).hasSize(1);
    }
}