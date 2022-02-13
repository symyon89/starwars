package com.starwars.service;

import com.starwars.model.Species;
import com.starwars.model.Vehicle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

class VehicleServiceTest {



    @Test
    void getVehiclesTest_returns_body() {
        WebTestClient.bindToServer()
                .baseUrl("https://swapi.dev/api/")
                .build()
                .get()
                .uri("/vehicles/")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Vehicle.Root.class).hasSize(1);
    }

    @Test
    void getVehicleByIdTest_returns_body() {
        WebTestClient.bindToServer()
                .baseUrl("https://swapi.dev/api/")
                .build()
                .get()
                .uri("vehicles/6/")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Vehicle.class).hasSize(1);
    }
}