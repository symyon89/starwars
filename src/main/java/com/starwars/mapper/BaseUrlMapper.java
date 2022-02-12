package com.starwars.mapper;

import java.util.ArrayList;
import java.util.List;


public class BaseUrlMapper {

    public String mapToBaseUrl(String apiUrl) {
        String localUrl = "http://localhost:8080/";
        String api = "https://swapi.dev/api/";

        return apiUrl !=null ? apiUrl.replace(api, localUrl) : null;
    }
    public List<String> mapArrayToBaseUrl(List<String> apiUrl) {
        if(apiUrl == null){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
         apiUrl.forEach(url -> result.add(mapToBaseUrl(url)));
        return result;
    }
}
