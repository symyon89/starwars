package com.starwars.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
public class ConfigProperties{
    private final String BASEURL  = "http://localhost:8080/";
    private final String URLAPI  = "https://swapi.dev/api/";

}
