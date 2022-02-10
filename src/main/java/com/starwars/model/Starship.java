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
        "model",
        "manufacturer",
        "cost_in_credits",
        "length",
        "max_atmosphering_speed",
        "crew",
        "passengers",
        "cargo_capacity",
        "consumables",
        "hyperdrive_rating",
        "MGLT",
        "starship_class",
        "pilots",
        "films",
        "created",
        "edited",
        "url"
})
@Generated("jsonschema2pojo")
public class Starship {

    @JsonProperty("name")
    public String name;
    @JsonProperty("model")
    public String model;
    @JsonProperty("manufacturer")
    public String manufacturer;
    @JsonProperty("cost_in_credits")
    public String costInCredits;
    @JsonProperty("length")
    public String length;
    @JsonProperty("max_atmosphering_speed")
    public String maxAtmospheringSpeed;
    @JsonProperty("crew")
    public String crew;
    @JsonProperty("passengers")
    public String passengers;
    @JsonProperty("cargo_capacity")
    public String cargoCapacity;
    @JsonProperty("consumables")
    public String consumables;
    @JsonProperty("hyperdrive_rating")
    public String hyperdriveRating;
    @JsonProperty("MGLT")
    public String mglt;
    @JsonProperty("starship_class")
    public String starshipClass;
    @JsonProperty("pilots")
    public List<Person> pilots;
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
