package com.starwars.controller;

import com.starwars.model.Planet;
import com.starwars.service.PlanetService;
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
    public Flux<Planet.Root> getPlanets(
            @RequestParam(required = false, defaultValue = "") String search,
            @RequestParam(required = false, defaultValue = "") String page
    ) {
        return planetService.getPlanets(search, page);
    }

    @GetMapping("/{id}")
    public Flux<Planet> getPlanetById(@PathVariable("id") String id) {
        return planetService.getPlanetById(id);
    }

}
