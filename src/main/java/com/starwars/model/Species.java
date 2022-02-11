package com.starwars.model;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.Date;


public class Species {
    public String name;
    public String classification;
    public String designation;
    @JsonSetter("average_height")
    public String averageHeight;
    @JsonSetter("skin_colors")
    public String skinColors;
    @JsonSetter("hair_colors")
    public String hairColors;
    @JsonSetter("eye_colors")
    public String eyeColors;
    @JsonSetter("average_lifespan")
    public String averageLifespan;
    public String homeworld;
    public String language;
    public ArrayList<String> people;
    public ArrayList<String> films;
    public Date created;
    public Date edited;
    public String url;


    public static class Root {
        public int count;
        public String next;
        public Object previous;
        public ArrayList<Species> results;
    }
}