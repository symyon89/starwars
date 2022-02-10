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
        "classification",
        "designation",
        "average_height",
        "skin_colors",
        "hair_colors",
        "eye_colors",
        "average_lifespan",
        "homeworld",
        "language",
        "people",
        "films",
        "created",
        "edited",
        "url"
})
@Generated("jsonschema2pojo")
public class Species {

    @JsonProperty("name")
    public String name;
    @JsonProperty("classification")
    public String classification;
    @JsonProperty("designation")
    public String designation;
    @JsonProperty("average_height")
    public String averageHeight;
    @JsonProperty("skin_colors")
    public String skinColors;
    @JsonProperty("hair_colors")
    public String hairColors;
    @JsonProperty("eye_colors")
    public String eyeColors;
    @JsonProperty("average_lifespan")
    public String averageLifespan;
    @JsonProperty("homeworld")
    public String homeworld;
    @JsonProperty("language")
    public String language;
    @JsonProperty("people")
    public List<Person> people;
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
