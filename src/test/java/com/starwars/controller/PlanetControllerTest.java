package com.starwars.controller;

import com.starwars.model.Planet;
import com.starwars.service.PlanetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@WebFluxTest(controllers = PlanetController.class)
class PlanetControllerTest {

    @MockBean
    private PlanetService planetService;

    @Autowired
    private WebTestClient webClient;

    @Test
    void getPlanetsTest_returns_Flux() {
        Planet.Root planetTest = new Planet.Root();
        List<Planet.Root> listPlanets = new ArrayList<>() {{
            add(planetTest);
        }};
        Flux<Planet.Root> planetFlux = Flux.fromIterable(listPlanets);
        when(planetService.getPlanets("","")).thenReturn(planetFlux);

        webClient.get()
                .uri("/planets")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Planet.Root.class);

        verify(planetService).getPlanets("","");
    }

    @Test
    void getPlanetByIdTest_returns_Flux() {
        Planet planetTest = new Planet();
        List<Planet> listPlanets = new ArrayList<>() {{
            add(planetTest);
        }};
        Flux<Planet> planetFlux = Flux.fromIterable(listPlanets);
        when(planetService.getPlanetById("1")).thenReturn(planetFlux);

        webClient.get()
                .uri("/planets/1")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Planet.Root.class);

        verify(planetService).getPlanetById("1");
    }
    @Test
    void shouldReturnOneRootPlanet(){
        WebTestClient.bindToServer().baseUrl("http://localhost:8080")
                .responseTimeout(Duration.ofMinutes(1))
                .build()
                .get()
                .uri("/planets")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectHeader()
                .contentType(APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].next").isEqualTo("http://localhost:8080/planets/?search=&page=2")
                .jsonPath("$[0].previous").isEmpty()
                .jsonPath("$[0].results").isNotEmpty();
    }
}