package com.starwars.controller;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.starwars.mapper.BaseUrlMapper;
import com.starwars.model.Film;
import com.starwars.service.FilmService;
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


@WebFluxTest(controllers = FilmController.class)
class FilmControllerTest {
    @MockBean
    private FilmService filmService;

    @Autowired
    private WebTestClient webClient;



    @Test
    void getFilmsTest_returns_Flux() {
        Film.Root filmTest = new Film.Root();
        filmTest.setCount(1);
        filmTest.setNext("next");
        filmTest.setPrevious("previous");
        filmTest.setResults(new ArrayList<>());

        List<Film.Root> listFlux = new ArrayList<>() {{
            add(filmTest);
        }};
        Flux<Film.Root> filmFlux = Flux.fromIterable(listFlux);

        when(filmService.getFilms("", ""))
                .thenReturn(filmFlux);

        webClient.get()
                .uri("/films")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Film.Root.class);

        verify(filmService).getFilms("", "");

    }

    @Test
    void getFilmByIdTest_returns_Flux() {
        Film filmTest = new Film();
        List<Film> listFlux = new ArrayList<>() {{
            add(filmTest);
        }};
        Flux<Film> filmFlux = Flux.fromIterable(listFlux);

        when(filmService.getFilmById("1"))
                .thenReturn(filmFlux);
        webClient.get()
                .uri("/films/1")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Film.class);

        verify(filmService).getFilmById("1");
    }


    @Test
    void shouldReturnOneRootFilm(){
         WebTestClient.bindToServer().baseUrl("http://localhost:8080")
                 .responseTimeout(Duration.ofMinutes(1))
                 .build()
                .get()
                .uri("/films")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectHeader()
                .contentType(APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].next").isEmpty()
                .jsonPath("$[0].previous").isEmpty()
                .jsonPath("$[0].results").isNotEmpty();
    }
}