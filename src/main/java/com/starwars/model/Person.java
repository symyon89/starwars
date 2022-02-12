package com.starwars.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.starwars.service.BaseUrlMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Person {

    private String name;
    private String height;
    private String mass;
    @JsonSetter("hair_color")
    private String hairColor;
    @JsonSetter("skin_color")
    private String skinColor;
    @JsonSetter("eye_color")
    private String eyeColor;
    @JsonSetter("birth_year")
    private String birthYear;
    private String gender;
    private String homeworld;
    private List<String> films;
    private List<String> species;
    private List<String> vehicles;
    private List<String> starships;
    private Date created;
    private Date edited;
    private String url;

    public void setHomeworld(String homeworld) {
        this.homeworld = BaseUrlMapper.mapToBaseUrl(homeworld);
    }

    public void setFilms(List<String> films) {
        this.films = BaseUrlMapper.mapArrayToBaseUrl(films);
    }

    public void setSpecies(List<String> species) {
        this.species = BaseUrlMapper.mapArrayToBaseUrl(species);
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = BaseUrlMapper.mapArrayToBaseUrl(vehicles);
    }

    public void setStarships(List<String> starships) {
        this.starships = BaseUrlMapper.mapArrayToBaseUrl(starships);
    }

    public void setUrl(String url) {
        this.url = BaseUrlMapper.mapToBaseUrl(url);
    }

    @Setter
    @Getter
    public static class Root {
        private int count;
        private String next;
        private String previous;
        private List<Person> results;

        public void setNext(String next) {
            this.next = BaseUrlMapper.mapToBaseUrl(next);
        }

        public void setPrevious(String previous) {
            this.previous = BaseUrlMapper.mapToBaseUrl(previous);
        }
    }
}