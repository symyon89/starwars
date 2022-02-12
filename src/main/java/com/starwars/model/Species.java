package com.starwars.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.starwars.service.BaseUrlMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Species {
    private String name;
    private String classification;
    private String designation;
    @JsonSetter("average_height")
    private String averageHeight;
    @JsonSetter("skin_colors")
    private String skinColors;
    @JsonSetter("hair_colors")
    private String hairColors;
    @JsonSetter("eye_colors")
    private String eyeColors;
    @JsonSetter("average_lifespan")
    private String averageLifespan;
    private String homeworld;
    private String language;
    private List<String> people;
    private List<String> films;
    private Date created;
    private Date edited;
    private String url;

    public void setHomeworld(String homeworld) {
        this.homeworld = BaseUrlMapper.mapToBaseUrl(homeworld);
    }

    public void setPeople(List<String> people) {
        this.people = BaseUrlMapper.mapArrayToBaseUrl(people);
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
        private List<Species> results;

        public void setNext(String next) {
            this.next = BaseUrlMapper.mapToBaseUrl(next);
        }

        public void setPrevious(String previous) {
            this.previous = BaseUrlMapper.mapToBaseUrl(previous);
        }
    }
}