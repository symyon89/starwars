package com.starwars.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.starwars.service.BaseUrlMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Vehicle {

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
    @JsonSetter("vehicle_class")
    private String vehicleClass;
    private List<String> pilots;
    private List<String> films;
    private Date created;
    private Date edited;
    private String url;

    public void setPilots(List<String> pilots) {
        this.pilots = BaseUrlMapper.mapArrayToBaseUrl(pilots);
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
        private List<Vehicle> results;

        public void setNext(String next) {
            this.next = BaseUrlMapper.mapToBaseUrl(next);
        }

        public void setPrevious(String previous) {
            this.previous = BaseUrlMapper.mapToBaseUrl(previous);
        }
    }
}