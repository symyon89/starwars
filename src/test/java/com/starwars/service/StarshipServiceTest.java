package com.starwars.service;

import com.starwars.model.Species;
import com.starwars.model.Starship;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

class StarshipServiceTest {


    @Test
    void getStarshipsTest_returns_body() {
        WebTestClient.bindToServer()
                .baseUrl("https://swapi.dev/api/")
                .build()
                .get()
                .uri("/starships/")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Starship.Root.class).hasSize(1);
    }

    @Test
    void getStarshipByIdTest_returns_body() {
        WebTestClient.bindToServer()
                .baseUrl("https://swapi.dev/api/")
                .build()
                .get()
                .uri("starships/15/")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Starship.class).hasSize(1);
    }
}