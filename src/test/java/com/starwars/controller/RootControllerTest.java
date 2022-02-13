package com.starwars.controller;

import com.starwars.model.Planet;
import com.starwars.model.Root;
import com.starwars.service.RootService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebFluxTest(controllers = RootController.class)
class RootControllerTest {

    @MockBean
    private RootService rootService;

    @Autowired
    private WebTestClient webClient;

    @Test
    void getRoot_returns_Flux() {
        Root root  = new Root();
        List<Root> list = new ArrayList<>() {{
            add(root);
        }};
        Flux<Root> rootFlux = Flux.fromIterable(list);
        when(rootService.getRoot()).thenReturn(rootFlux);

        webClient.get()
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Root.class);
        verify(rootService).getRoot();
    }
}