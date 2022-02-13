package com.starwars.service;

import com.starwars.model.Planet;
import com.starwars.model.Root;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;

class RootServiceTest {

    @Test
    void getRoot_returns_flux() {
        WebTestClient.bindToServer()
                .baseUrl("https://swapi.dev/api/")
                .build()
                .get()
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Root.class).hasSize(1);
    }

    @Test
    void shouldReturnOneRoot(){
        WebTestClient.bindToServer().baseUrl("http://localhost:8080")
                .responseTimeout(Duration.ofMinutes(1))
                .build()
                .get()
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectHeader()
                .contentType(APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].people").isEqualTo("http://localhost:8080/people/")
                .jsonPath("$[0].planets").isEqualTo("http://localhost:8080/planets/")
                .jsonPath("$[0].starships").isEqualTo("http://localhost:8080/starships/");
    }
}