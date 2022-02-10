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
        "height",
        "mass",
        "hair_color",
        "skin_color",
        "eye_color",
        "birth_year",
        "gender",
        "homeworld",
        "films",
        "species",
        "vehicles",
        "starships",
        "created",
        "edited",
        "url"
})
@Generated("jsonschema2pojo")
public class Person {

    @JsonProperty("name")
    public String name;
    @JsonProperty("height")
    public String height;
    @JsonProperty("mass")
    public String mass;
    @JsonProperty("hair_color")
    public String hairColor;
    @JsonProperty("skin_color")
    public String skinColor;
    @JsonProperty("eye_color")
    public String eyeColor;
    @JsonProperty("birth_year")
    public String birthYear;
    @JsonProperty("gender")
    public String gender;
    @JsonProperty("homeworld")
    public String homeworld;
    @JsonProperty("films")
    public List<Film> films;
    @JsonProperty("species")
    public List<Species> species;
    @JsonProperty("vehicles")
    public List<Vehicle> vehicles;
    @JsonProperty("starships")
    public List<Starship> starships;
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