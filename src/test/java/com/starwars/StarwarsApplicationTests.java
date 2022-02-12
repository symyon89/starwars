package com.starwars;

import com.starwars.model.Film;

import com.starwars.model.Person;
import com.starwars.service.FilmService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;


import static org.mockito.Mockito.doReturn;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class StarwarsApplicationTests {

    @Test
    void contextLoads() {
//        doReturn(webClient);
//        Film [] films = {new Film(),new Film()};
//        doReturn(Flux.fromArray(films)).when(webClient).get().uri("any(").retrieve().bodyToFlux(Film.Root.class);
//
//        new FilmService(builder);


    }

}
