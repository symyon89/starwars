package com.starwars.controller;

import com.starwars.model.Film;
import com.starwars.model.Species;
import com.starwars.service.SpeciesService;
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

@WebFluxTest(controllers = SpeciesController.class)
class SpeciesControllerTest {

    @MockBean
    SpeciesService speciesService;

    @Autowired
    WebTestClient webClient;

    @Test
    void getSpeciesTest_returns_Flux() {
        Species.Root speciesTest = new Species.Root();
        List<Species.Root> listFlux = new ArrayList<>() {{
            add(speciesTest);
        }};
        Flux<Species.Root> speciesFlux = Flux.fromIterable(listFlux);

        when(speciesService.getSpecies("", ""))
                .thenReturn(speciesFlux);

        webClient.get()
                .uri("/species")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Species.Root.class);

        verify(speciesService).getSpecies("", "");
    }

    @Test
    void getSpeciesByIdTest_returns_Flux() {
        Species speciesTest = new Species();
        List<Species> listFlux = new ArrayList<>() {{
            add(speciesTest);
        }};
        Flux<Species> speciesFlux = Flux.fromIterable(listFlux);

        when(speciesService.getSpeciesById("1"))
                .thenReturn(speciesFlux);

        webClient.get()
                .uri("/species/1")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Species.class);

        verify(speciesService).getSpeciesById("1");
    }
    @Test
    void shouldReturnOneRootSpecies(){
        WebTestClient.bindToServer().baseUrl("http://localhost:8080")
                .responseTimeout(Duration.ofMinutes(1))
                .build()
                .get()
                .uri("/species")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectHeader()
                .contentType(APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].next").isEqualTo("http://localhost:8080/species/?search=&page=2")
                .jsonPath("$[0].previous").isEmpty()
                .jsonPath("$[0].results").isNotEmpty();
    }
}