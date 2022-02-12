package com.starwars.controller;

import com.starwars.model.Species;
import com.starwars.service.SpeciesService;
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
    public Flux<Species.Root> getSpecies(
            @RequestParam(required = false, defaultValue = "") String search,
            @RequestParam(required = false, defaultValue = "") String page
    ) {
        return speciesService.getSpecies(search, page);
    }

    @GetMapping("/{id}")
    public Flux<Species> getSpeciesById(@PathVariable("id") String id) {
        return speciesService.getSpeciesById(id);
    }
}
