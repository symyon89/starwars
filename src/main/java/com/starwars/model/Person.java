package com.starwars.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.starwars.mapper.BaseUrlMapper;
import lombok.AccessLevel;
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
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final BaseUrlMapper mapper = new BaseUrlMapper();

    public void setHomeworld(String homeworld) {
        this.homeworld = mapper.mapToBaseUrl(homeworld);
    }

    public void setFilms(List<String> films) {
        this.films = mapper.mapArrayToBaseUrl(films);
    }

    public void setSpecies(List<String> species) {
        this.species = mapper.mapArrayToBaseUrl(species);
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = mapper.mapArrayToBaseUrl(vehicles);
    }

    public void setStarships(List<String> starships) {
        this.starships = mapper.mapArrayToBaseUrl(starships);
    }

    public void setUrl(String url) {
        this.url = mapper.mapToBaseUrl(url);
    }

    @Setter
    @Getter
    public static class Root {
        private int count;
        private String next;
        private String previous;
        private List<Person> results;
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