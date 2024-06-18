package com.example.geolocation.model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FeatureCollection {

    @JsonProperty("type")
    private String type;

    @JsonProperty("features")
    private Feature[] features;

    // Constructor, getters, and setters
    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }
// Getter for features array.
    public Feature[] getFeatures() {

        return features;
    }

    public void setFeatures(Feature[] features) {

        this.features = features;
    }
}
