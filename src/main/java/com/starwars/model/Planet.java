package com.starwars.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.starwars.mapper.BaseUrlMapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Planet {
    private String name;
    @JsonSetter("rotation_period")
    private String rotationPeriod;
    @JsonSetter("orbital_period")
    private String orbitalPeriod;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    @JsonSetter("surface_water")
    private String surfaceWater;
    private String population;
    private List<String> residents;
    private List<String> films;
    private LocalDate created;
    private LocalDate edited;
    private String url;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final BaseUrlMapper mapper = new BaseUrlMapper();

    public void setResidents(List<String> residents) {
        this.residents = mapper.mapArrayToBaseUrl(residents);
    }

    public void setFilms(List<String> films) {
        this.films = mapper.mapArrayToBaseUrl(films);
    }

    public void setUrl(String url) {
        this.url = mapper.mapToBaseUrl(url);
    }

    @Getter
    @Setter
    public static class Root {
        private int count;
        private String next;
        private String previous;
        private List<Planet> results;
        @Getter(AccessLevel.NONE)
        @Setter(AccessLevel.NONE)
        private final BaseUrlMapper mapper = new BaseUrlMapper();

        public void setNext(String next) {
            this.next = mapper.mapToBaseUrl(next);
        }

        public void setPrevious(String previous) {
            this.previous = mapper.mapToBaseUrl(previous);
        }
    }

}