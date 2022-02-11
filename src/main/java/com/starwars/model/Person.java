package com.starwars.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;

@ToString
public class Person {


    public String name;
    public String height;
    public String mass;
    @JsonSetter("hair_color")
    public String hairColor;
    @JsonSetter("skin_color")
    public String skinColor;
    @JsonSetter("eye_color")
    public String eyeColor;
    @JsonSetter("birth_year")
    public String birthYear;
    public String gender;
    public String homeworld;
    public ArrayList<String> films;
    public ArrayList<String> species;
    public ArrayList<String> vehicles;
    public ArrayList<String> starships;
    public Date created;
    public Date edited;
    public String url;


    public static class Root {
        public int count;
        public String next;
        public Object previous;
        public ArrayList<Person> results;
    }
}