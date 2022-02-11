package com.starwars.controller;

import com.starwars.model.Root;
import com.starwars.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<Flux<Root>> getFilms(
            @RequestParam(required = false) String search,
            @RequestParam(required =false) String page
    ) {
        return new ResponseEntity<>(filmService.getFilms(search,page), HttpStatus.OK);
    }
}
