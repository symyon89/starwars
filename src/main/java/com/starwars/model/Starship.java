package com.starwars.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.starwars.config.ConfigProperties;
import com.starwars.mapper.BaseUrlMapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Starship {
    private String name;
    private String model;
    private String manufacturer;
    @JsonSetter("cost_in_credits")
    private String costInCredits;
    private String length;
    @JsonSetter("max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    private String crew;
    private String passengers;
    @JsonSetter("cargo_capacity")
    private String cargoCapacity;
    private String consumables;
    @JsonSetter("hyperdrive_rating")
    private String hyperdriveRating;
    @JsonSetter("MGLT")
    private String mglt;
    @JsonSetter("starship_class")
    private String starshipClass;
    private List<String> pilots;
    private List<String> films;
    private LocalDate created;
    private LocalDate edited;
    private String url;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final BaseUrlMapper mapper = new BaseUrlMapper();

    public void setPilots(List<String> pilots) {
        this.pilots = mapper.mapArrayToBaseUrl(pilots);
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
        private List<Starship> results;
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