package com.starwars.controller;

import com.starwars.model.Film;
import com.starwars.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<Flux<Film.Root>> getFilms(
            @RequestParam(required = false, defaultValue = "") String search,
            @RequestParam(required =false, defaultValue = "") String page
    ) {
        return new ResponseEntity<>(filmService.getFilms(search,page), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flux<Film>> getFilmById(@PathVariable("id") String id) {
        return new ResponseEntity<>(filmService.getFilmById(id), HttpStatus.OK);
    }
}
