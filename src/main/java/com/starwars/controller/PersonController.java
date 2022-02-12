package com.starwars.controller;

import com.starwars.model.Person;
import com.starwars.service.PersonService;
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
    public Flux<Person.Root> getPeople(
            @RequestParam(required = false, defaultValue = "") String search,
            @RequestParam(required = false, defaultValue = "") String page
    ) {
        return personService.getPeople(search, page);
    }

    @GetMapping("/{id}")
    public Flux<Person> getPersonById(@PathVariable("id") String id) {
        return personService.getPersonById(id);
    }
}


