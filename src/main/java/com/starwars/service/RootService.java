package com.starwars.service;

import com.starwars.exceptions.PageNotFoundException;
import com.starwars.exceptions.ServerException;
import com.starwars.model.Root;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RootService {
    private final WebClient builder;

    public RootService(WebClient builder) {
        this.builder = builder;
    }

    public Flux<Root> getRoot() {
        return builder
                .get()
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new ServerException("Error 500")))
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new PageNotFoundException("Error 400")))
                .bodyToFlux(Root.class);
    }
}
