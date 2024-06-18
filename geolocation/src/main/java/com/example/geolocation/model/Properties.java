package com.example.geolocation.model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Properties {

    private String ADMIN;
    private String ISO_A3;
    private String ISO_A2;

    // Getters and setters
    @JsonProperty("ADMIN")
    public String getADMIN() {
        return ADMIN;
    }

    public void setADMIN(String ADMIN) {
        this.ADMIN = ADMIN;
    }

    @JsonProperty("ISO_A3")
    public String getISO_A3() {

        return ISO_A3;
    }

    public void setISO_A3(String ISO_A3) {

        this.ISO_A3 = ISO_A3;
    }

    @JsonProperty("ISO_A2")
    public String getISO_A2() {

        return ISO_A2;
    }

    public void setISO_A2(String ISO_A2) {

        this.ISO_A2 = ISO_A2;
    }
}
