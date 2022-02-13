package com.starwars.service;

import com.starwars.model.Film;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

class FilmServiceTest {


    @Test
    void getFilmsTest_returns_body() {
        WebTestClient.bindToServer()
                .baseUrl("https://swapi.dev/api/")
                .build()
                .get()
                .uri("/films")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Film.Root.class).hasSize(1);
    }

    @Test
    void getFilmByIdTest_returns_body() {


        WebTestClient.bindToServer()
                .baseUrl("https://swapi.dev/api/")
                .build()
                .get()
                .uri("/films/1")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Film.class).hasSize(1);
    }
}