package com.starwars.model;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.Date;


public class Planet {
    public String name;
    @JsonSetter("rotation_period")
    public String rotationPeriod;
    @JsonSetter("orbital_period")
    public String orbitalPeriod;
    public String diameter;
    public String climate;
    public String gravity;
    public String terrain;
    @JsonSetter("surface_water")
    public String surfaceWater;
    public String population;
    public ArrayList<String> residents;
    public ArrayList<String> films;
    public Date created;
    public Date edited;
    public String url;


    public static class Root {
        public int count;
        public String next;
        public Object previous;
        public ArrayList<Planet> results;
    }

}