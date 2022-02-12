package com.starwars.controller;

import com.starwars.model.Starship;
import com.starwars.service.StarshipService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/starships")
public class StarshipController {
    private final StarshipService starshipService;

    public StarshipController(StarshipService starshipService) {
        this.starshipService = starshipService;
    }

    @GetMapping
    public Flux<Starship.Root> getStarships(
            @RequestParam(required = false, defaultValue = "") String search,
            @RequestParam(required = false, defaultValue = "") String page
    ) {
        return starshipService.getStarships(search, page);
    }

    @GetMapping("/{id}")
    public Flux<Starship> getStarshipById(@PathVariable("id") String id) {
        return starshipService.getStarshipById(id);
    }
}
