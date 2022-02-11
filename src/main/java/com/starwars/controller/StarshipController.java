package com.starwars.controller;

import com.starwars.model.Starship;
import com.starwars.service.StarshipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/starships")
public class StarshipController {
    private final StarshipService starshipService;

    public StarshipController(StarshipService starshipService) {
        this.starshipService = starshipService;
    }

    @GetMapping
    public ResponseEntity<Flux<Starship>> getSpecies(
            @RequestParam(required = false, defaultValue = "") String search,
            @RequestParam(required = false, defaultValue = "") String page,
            @RequestParam(required = false, defaultValue = "") String format
    ) {
        return new ResponseEntity<>(starshipService.getStarships(search, page, format), HttpStatus.OK);
    }
}
