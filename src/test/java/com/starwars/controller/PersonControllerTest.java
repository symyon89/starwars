package com.starwars.controller;

import com.starwars.model.Person;
import com.starwars.service.PersonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;


@WebFluxTest(controllers = PersonController.class)
class PersonControllerTest {
    @MockBean
    private PersonService personService;

    @Autowired
    private WebTestClient webClient;

    @Test
    void getPeopleTest_returns_Flux() {
        Person.Root personTest = new Person.Root();

        List<Person.Root> listFlux = new ArrayList<>() {{
            add(personTest);
        }};
        Flux<Person.Root> personFlux = Flux.fromIterable(listFlux);

        Mockito.when(personService.getPeople("", ""))
                .thenReturn(personFlux);

        webClient.get()
                .uri("/people")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(Person.Root.class);

        verify(personService).getPeople("","");

    }

    @Test
    void getPersonByIdTest_returns_Flux() {
        Person personTest = new Person();
        List<Person> listPerson = new ArrayList<>() {{
            add(personTest);
        }};
        Flux<Person> personFlux = Flux.fromIterable(listPerson);

        when(personService.getPersonById("1")).thenReturn(personFlux);

        webClient.get()
                .uri("/people/1")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Person.class);

        verify(personService).getPersonById("1");
    }
    @Test
    void shouldReturnOneRootPeople(){
        WebTestClient.bindToServer().baseUrl("http://localhost:8080")
                .responseTimeout(Duration.ofMinutes(1))
                .build()
                .get()
                .uri("/people")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectHeader()
                .contentType(APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].next").isEqualTo("http://localhost:8080/people/?search=&page=2")
                .jsonPath("$[0].previous").isEmpty()
                .jsonPath("$[0].results").isNotEmpty();
    }
}