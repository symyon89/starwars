package com.starwars.config;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.*;

class WebFluxConfigTest {

    @Test
    void getWebClient_returns_WebClient() {
        WebFluxConfig web = new WebFluxConfig();

        WebClient webClientresult = web.getWebClient();
        assertNotNull(webClientresult);
    }
}