package com.starwars.controller;

import com.starwars.model.Species;
import com.starwars.service.SpeciesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/species")
public class SpeciesController {
    private final SpeciesService speciesService;

    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    @GetMapping
    public ResponseEntity<Flux<Species.Root>> getSpecies(
            @RequestParam(required = false, defaultValue = "") String search,
            @RequestParam(required = false, defaultValue = "") String page
    ) {
        return new ResponseEntity<>(speciesService.getSpecies(search, page), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flux<Species>> getSpeciesById(@PathVariable("id") String id) {
        return new ResponseEntity<>(speciesService.getSpeciesById(id), HttpStatus.OK);
    }
}
