package com.starwars.controller;

import com.starwars.model.Starship;
import com.starwars.service.StarshipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Flux<Starship.Root>> getStarships(
            @RequestParam(required = false, defaultValue = "") String search,
            @RequestParam(required = false, defaultValue = "") String page
    ) {
        return new ResponseEntity<>(starshipService.getStarships(search, page), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flux<Starship>> getStarshipById(@PathVariable("id") String id) {
        return new ResponseEntity<>(starshipService.getStarshipById(id), HttpStatus.OK);
    }
}
