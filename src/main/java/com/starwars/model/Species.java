package com.starwars.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.starwars.config.ConfigProperties;
import com.starwars.mapper.BaseUrlMapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
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
    private LocalDate created;
    private LocalDate edited;
    private String url;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final BaseUrlMapper mapper = new BaseUrlMapper();

    public void setHomeworld(String homeworld) {
        this.homeworld = mapper.mapToBaseUrl(homeworld);
    }

    public void setPeople(List<String> people) {
        this.people = mapper.mapArrayToBaseUrl(people);
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
        private List<Species> results;
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