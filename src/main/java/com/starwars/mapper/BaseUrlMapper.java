package com.starwars.mapper;


import com.starwars.config.ConfigProperties;

import java.util.ArrayList;
import java.util.List;

public class BaseUrlMapper {
    ConfigProperties configProperties = new ConfigProperties();

    public String mapToBaseUrl(String apiUrl) {


        return apiUrl !=null ? apiUrl.replace(configProperties.getURLAPI(), configProperties.getBASEURL()) : null;
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
