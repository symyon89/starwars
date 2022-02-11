package com.starwars.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.Date;


public class Starship {
    public String name;
    public String model;
    public String manufacturer;
    @JsonSetter("cost_in_credits")
    public String costInCredits;
    public String length;
    @JsonSetter("max_atmosphering_speed")
    public String maxAtmospheringSpeed;
    public String crew;
    public String passengers;
    @JsonSetter("cargo_capacity")
    public String cargoCapacity;
    public String consumables;
    @JsonSetter("hyperdrive_rating")
    public String hyperdriveRating;
    @JsonSetter("MGLT")
    public String mglt;
    @JsonSetter("starship_class")
    public String starshipClass;
    public ArrayList<String> pilots;
    public ArrayList<String> films;
    public Date created;
    public Date edited;
    public String url;


    public static class Root {
        public int count;
        public String next;
        public Object previous;
        public ArrayList<Starship> results;
    }

}