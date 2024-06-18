package com.example.geolocation.controller;

import com.example.geolocation.service.CountryLocatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryLocatorController {
    @Autowired
    private CountryLocatorService countryLocatorService;

    @GetMapping("/getCountryCode")
    public String getCountryCode(@RequestParam double latitude, @RequestParam double longitude) {
        // Retrieve country code based on latitude and longitude
        return countryLocatorService.getCountryCode(latitude, longitude);
    }
}
