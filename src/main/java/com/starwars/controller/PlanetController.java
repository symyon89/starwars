package com.starwars.controller;

import com.starwars.model.Planet;
import com.starwars.service.PlanetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    private final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping
    public ResponseEntity<Flux<Planet.Root>> getPlanets(
            @RequestParam(required = false, defaultValue = "") String search,
            @RequestParam(required = false, defaultValue = "") String page
    ) {
        return new ResponseEntity<>(planetService.getPlanets(search, page), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flux<Planet>> getPlanetById(@PathVariable("id") String id) {
        return new ResponseEntity<>(planetService.getPlanetById(id), HttpStatus.OK);
    }

}
