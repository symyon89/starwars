package com.starwars.mapper;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseUrlMapperTest {
    BaseUrlMapper mapper = new BaseUrlMapper();

    @Test
    void mapToBaseUrlTest_returns_String() {
        String toRecive = "http://localhost:8080/";
        String toSend = "https://swapi.dev/api/";


        String result = mapper.mapToBaseUrl(toSend);

        assertEquals(toRecive, result);
    }
    @Test
    void mapToBaseUrlTest_returns_null() {

        String result = mapper.mapToBaseUrl(null);
        assertNull(result);
    }

    @Test
    void mapArrayToBaseUrlTest_returns_List() {
        List<String> listToTest = new ArrayList<>(){{
            add("https://swapi.dev/api/");
        }};
        List<String> result = mapper.mapArrayToBaseUrl(listToTest);

        assertEquals("http://localhost:8080/",result.get(0));
    }

    @Test
    void mapArrayToBaseUrlTest_returns_EmptyList() {

        List<String> result = mapper.mapArrayToBaseUrl(null);
        assertEquals(new ArrayList<>() ,result);
    }
}