package com.starwars.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.starwars.mapper.BaseUrlMapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Film {
    private String title;
    @JsonSetter("episode_id")
    private int episodeId;
    @JsonSetter("opening_crawl")
    private String openingCrawl;
    private String director;
    private String producer;
    @JsonSetter("release_date")
    private String releaseDate;
    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;
    private Date created;
    private Date edited;
    private String url;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final BaseUrlMapper mapper = new BaseUrlMapper();

    public void setCharacters(List<String> characters) {
        this.characters = mapper.mapArrayToBaseUrl(characters);
    }

    public void setPlanets(List<String> planets) {
        this.planets = mapper.mapArrayToBaseUrl(planets);
    }

    public void setStarships(List<String> starships) {
        this.starships = mapper.mapArrayToBaseUrl(starships);
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = mapper.mapArrayToBaseUrl(vehicles);
    }

    public void setSpecies(List<String> species) {
        this.species = mapper.mapArrayToBaseUrl(species);
    }

    public void setUrl(String url) {
        this.url = mapper.mapToBaseUrl(url);
    }

    @Setter
    @Getter
    public static class Root {
        private String next;
        private String previous;
        private int count;
        private ArrayList<Film> results;
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