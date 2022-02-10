package com.starwars.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "rotation_period",
        "orbital_period",
        "diameter",
        "climate",
        "gravity",
        "terrain",
        "surface_water",
        "population",
        "residents",
        "films",
        "created",
        "edited",
        "url"
})
@Generated("jsonschema2pojo")
public class Planet {

    @JsonProperty("name")
    public String name;
    @JsonProperty("rotation_period")
    public String rotationPeriod;
    @JsonProperty("orbital_period")
    public String orbitalPeriod;
    @JsonProperty("diameter")
    public String diameter;
    @JsonProperty("climate")
    public String climate;
    @JsonProperty("gravity")
    public String gravity;
    @JsonProperty("terrain")
    public String terrain;
    @JsonProperty("surface_water")
    public String surfaceWater;
    @JsonProperty("population")
    public String population;
    @JsonProperty("residents")
    public List<Person> residents;
    @JsonProperty("films")
    public List<Film> films;
    @JsonProperty("created")
    public String created;
    @JsonProperty("edited")
    public String edited;
    @JsonProperty("url")
    public String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}