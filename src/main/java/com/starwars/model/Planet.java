package com.starwars.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.starwars.service.BaseUrlMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
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
    private Date created;
    private Date edited;
    private String url;

    public void setResidents(List<String> residents) {
        this.residents = BaseUrlMapper.mapArrayToBaseUrl(residents);
    }

    public void setFilms(List<String> films) {
        this.films = BaseUrlMapper.mapArrayToBaseUrl(films);
    }

    public void setUrl(String url) {
        this.url = BaseUrlMapper.mapToBaseUrl(url);
    }

    @Getter
    @Setter
    public static class Root {
        private int count;
        private String next;
        private String previous;
        private List<Planet> results;

        public void setNext(String next) {
            this.next = BaseUrlMapper.mapToBaseUrl(next);
        }

        public void setPrevious(String previous) {
            this.previous = BaseUrlMapper.mapToBaseUrl(previous);
        }
    }

}