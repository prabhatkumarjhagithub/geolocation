package com.example.geolocation.model;
import java.util.List;

public class Geometry {

    private String type;
    private List<List<List<List<Double>>>> coordinates;

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }
// Getter for coordinates
    public List<List<List<List<Double>>>> getCoordinates() {

        return coordinates;
    }
// Setter for coordinates
    public void setCoordinates(List<List<List<List<Double>>>> coordinates) {

        this.coordinates = coordinates;
    }
}
