package com.starwars.model;

import com.starwars.mapper.BaseUrlMapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


@Getter
public class Root{
    private String people;
    private String planets;
    private String films;
    private String species;
    private String vehicles;
    private String starships;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final BaseUrlMapper mapper = new BaseUrlMapper();

    public void setPeople(String people) {
        this.people = mapper.mapToBaseUrl(people);
    }

    public void setPlanets(String planets) {
        this.planets = mapper.mapToBaseUrl(planets);
    }

    public void setFilms(String films) {
        this.films = mapper.mapToBaseUrl(films);
    }

    public void setSpecies(String species) {
        this.species = mapper.mapToBaseUrl(species);
    }

    public void setVehicles(String vehicles) {
        this.vehicles = mapper.mapToBaseUrl(vehicles);
    }

    public void setStarships(String starships) {
        this.starships = mapper.mapToBaseUrl(starships);
    }
}
