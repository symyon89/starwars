package com.starwars.model;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;

@ToString
public class Film{
    public String title;
    public int episode_id;
    public String opening_crawl;
    public String director;
    public String producer;
    public String release_date;
    public ArrayList<String> characters;
    public ArrayList<String> planets;
    public ArrayList<String> starships;
    public ArrayList<String> vehicles;
    public ArrayList<String> species;
    public Date created;
    public Date edited;
    public String url;
}

