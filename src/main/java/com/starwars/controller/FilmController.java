package com.starwars.controller;

import com.starwars.model.Film;
import com.starwars.service.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;



@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public Flux<Film.Root> getFilms(
            @RequestParam(required = false, defaultValue = "") String search,
            @RequestParam(required = false, defaultValue = "") String page
    ) {
        return filmService.getFilms(search,page);
    }

    @GetMapping("/{id}")
    public Flux<Film> getFilmById(@PathVariable("id") String id) {

        return filmService.getFilmById(id);
    }
}
