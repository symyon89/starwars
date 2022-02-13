package com.starwars.controller;

import com.starwars.model.Root;
import com.starwars.service.RootService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping
public class RootController {
    private final RootService rootService;

    public RootController(RootService rootService) {
        this.rootService = rootService;
    }
    @GetMapping
    public Flux<Root> getRoot(){
        return rootService.getRoot();
    }
}
