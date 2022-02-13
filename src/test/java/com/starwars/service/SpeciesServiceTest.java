package com.starwars.service;

import com.starwars.model.Planet;
import com.starwars.model.Species;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

class SpeciesServiceTest {



    @Test
    void getSpeciesTest_returns_body() {
            WebTestClient.bindToServer()
                    .baseUrl("https://swapi.dev/api/")
                    .build()
                    .get()
                    .uri("/species/")
                    .exchange()
                    .expectStatus().isOk()
                    .expectBodyList(Species.Root.class).hasSize(1);
    }

    @Test
    void getSpeciesByIdTest_returns_body() {
        WebTestClient.bindToServer()
                .baseUrl("https://swapi.dev/api/")
                .build()
                .get()
                .uri("/species/1")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Species.class).hasSize(1);
    }
}