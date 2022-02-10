package com.starwars.controller;

import com.starwars.model.Film;
import com.starwars.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<Mono<List<Film>>> getAllFilms() {
        Mono<List<Film>> address = filmService.dosomething();
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
}
