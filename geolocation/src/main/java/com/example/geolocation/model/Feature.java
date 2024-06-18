package com.example.geolocation.model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Feature {

    private String type;
    private Properties properties;
    private Geometry geometry;

    // Getters and setters
    @JsonProperty("type")
    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    @JsonProperty("properties")
    public Properties getProperties() {

        return properties;
    }

    public void setProperties(Properties properties) {

        this.properties = properties;
    }

    @JsonProperty("geometry")
    public Geometry getGeometry() {

        return geometry;
    }
//Setter the Geometry
    public void setGeometry(Geometry geometry) {

        this.geometry = geometry;
    }
}
