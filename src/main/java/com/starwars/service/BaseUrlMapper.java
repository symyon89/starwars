package com.starwars.service;

import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;


public class BaseUrlMapper {
    //@Value("${spring.webflux.base-path}")
    private static String baseUrl = "https://swapi.dev/api/";
    //@Value("${server.root}" + "${server.port}")
    private static String localUrl = "http://localhost:8080/";

    public static String mapToBaseUrl(String apiUrl) {
        return apiUrl !=null ? apiUrl.replace(baseUrl,localUrl) : null;
    }
    public static List<String> mapArrayToBaseUrl(List<String> apiUrl) {
        List<String> result = new ArrayList<>();
         apiUrl.forEach(url -> result.add(mapToBaseUrl(url)));
        return result;
    }
}
