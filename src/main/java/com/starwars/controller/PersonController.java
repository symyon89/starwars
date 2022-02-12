package com.starwars.controller;

import com.starwars.model.Person;
import com.starwars.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<Flux<Person.Root>> getPeople(
            @RequestParam(required = false, defaultValue = "") String search,
            @RequestParam(required = false, defaultValue = "") String page
    ) {
        return new ResponseEntity<>(personService.getPeople(search, page), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flux<Person>> getPersonById(@PathVariable("id") String id) {
        return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.OK);
    }
}


