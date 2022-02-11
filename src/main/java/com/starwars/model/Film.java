package com.starwars.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;

@ToString
public class Film {
    public String title;
    @JsonSetter("episode_id")
    public int episodeId;
    @JsonSetter("opening_crawl")
    public String openingCrawl;
    public String director;
    public String producer;
    @JsonSetter("release_date")
    public String releaseDate;
    public ArrayList<String> characters;
    public ArrayList<String> planets;
    public ArrayList<String> starships;
    public ArrayList<String> vehicles;
    public ArrayList<String> species;
    public Date created;
    public Date edited;
    public String url;


    public static class Root {
        public Object next;
        public Object previous;
        public int count;
        public ArrayList<Film> results;
    }

}