package com.starwars.controller;

import com.starwars.model.Species;
import com.starwars.model.Vehicle;
import com.starwars.service.VehicleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@WebFluxTest(controllers = VehicleController.class)
class VehicleControllerTest {
    @MockBean
    VehicleService vehicleService;

    @Autowired
    WebTestClient webClient;

    @Test
    void getVehiclesTest_returns_Flux() {
        Vehicle.Root vehicleTest = new Vehicle.Root();
        List<Vehicle.Root> listFlux = new ArrayList<>() {{
            add(vehicleTest);
        }};
        Flux<Vehicle.Root> vehicleFlux = Flux.fromIterable(listFlux);

        when(vehicleService.getVehicles("", ""))
                .thenReturn(vehicleFlux);

        webClient.get()
                .uri("/vehicles")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Vehicle.Root.class);

        verify(vehicleService).getVehicles("", "");
    }

    @Test
    void getVehicleByIdTest_returns_Flux() {
        Vehicle vehicleTest = new Vehicle();
        List<Vehicle> listFlux = new ArrayList<>() {{
            add(vehicleTest);
        }};
        Flux<Vehicle> vehicleFlux = Flux.fromIterable(listFlux);

        when(vehicleService.getVehicleById("1"))
                .thenReturn(vehicleFlux);

        webClient.get()
                .uri("/vehicles/1")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Vehicle.class);

        verify(vehicleService).getVehicleById("1");
    }
    @Test
    void shouldReturnOneRootVehicle(){
        WebTestClient.bindToServer().baseUrl("http://localhost:8080")
                .responseTimeout(Duration.ofMinutes(1))
                .build()
                .get()
                .uri("/vehicles")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectHeader()
                .contentType(APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].next").isEqualTo("http://localhost:8080/vehicles/?search=&page=2")
                .jsonPath("$[0].previous").isEmpty()
                .jsonPath("$[0].results").isNotEmpty();
    }
}