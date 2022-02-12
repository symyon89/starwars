package com.starwars.controller;

import com.starwars.model.Species;
import com.starwars.model.Starship;
import com.starwars.service.StarshipService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@WebFluxTest(controllers = StarshipController.class)
class StarshipControllerTest {

    @MockBean
    StarshipService starshipService;

    @Autowired
    WebTestClient webClient;

    @Test
    void getStarships() {
        Starship.Root starshipTest = new Starship.Root();
        List<Starship.Root> listFlux = new ArrayList<>() {{
            add(starshipTest);
        }};
        Flux<Starship.Root> starshipFlux = Flux.fromIterable(listFlux);

        when(starshipService.getStarships("", ""))
                .thenReturn(starshipFlux);

        webClient.get()
                .uri("/starships")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Starship.Root.class);

        verify(starshipService).getStarships("", "");
    }

    @Test
    void getStarshipById() {
        Starship speciesTest = new Starship();
        List<Starship> listFlux = new ArrayList<>() {{
            add(speciesTest);
        }};
        Flux<Starship> speciesFlux = Flux.fromIterable(listFlux);

        when(starshipService.getStarshipById("1"))
                .thenReturn(speciesFlux);

        webClient.get()
                .uri("/starships/1")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Starship.Root.class);

        verify(starshipService).getStarshipById("1");
    }

    @Test
    void shouldReturnOneRootStarship(){
        WebTestClient.bindToServer().baseUrl("http://localhost:8080")
                .responseTimeout(Duration.ofMinutes(1))
                .build()
                .get()
                .uri("/starships")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectHeader()
                .contentType(APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].next").isEqualTo("http://localhost:8080/starships/?search=&page=2")
                .jsonPath("$[0].previous").isEmpty()
                .jsonPath("$[0].results").isNotEmpty();
    }
}