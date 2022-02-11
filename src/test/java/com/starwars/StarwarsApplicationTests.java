package com.starwars;

import com.starwars.model.Film;
import com.starwars.model.Root;
import com.starwars.service.FilmService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class StarwarsApplicationTests {

    @Spy
    WebClient webClient;

    @Mock
    WebClient.Builder builder;

    @Test
    void contextLoads() {
        doReturn(webClient)
        doReturn(Flux.fromArray(new Film[])).when(webClient).get().uri("any(").retrieve().bodyToFlux(Root.class);

        new FilmService(builder)
    }

}
