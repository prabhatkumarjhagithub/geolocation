package com.example.geolocation.model;

import java.util.List;

public class Country {
    private String isoCode;
    private List<Boundary> boundaries;

    public String getIsoCode() {

        return isoCode;
    }

    public void setIsoCode(String isoCode) {

        this.isoCode = isoCode;
    }

    public List<Boundary> getBoundaries() {

        return boundaries;
    }

    public void setBoundaries(List<Boundary> boundaries) {

        this.boundaries = boundaries;
    }

public boolean contains(double latitude, double longitude) {
    // Iterate through each boundary in the boundaries list
    for (Boundary boundary : boundaries) {
        // Check if the point is inside the current boundary
        if (boundary.contains(latitude, longitude)) {
            return true;
        }
    }
    return false;
}

}
