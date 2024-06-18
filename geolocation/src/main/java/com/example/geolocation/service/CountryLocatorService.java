package com.example.geolocation.service;

import com.example.geolocation.model.Country;
import com.example.geolocation.model.Feature;
import com.example.geolocation.model.FeatureCollection;
import com.example.geolocation.model.Geometry;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import java.util.HashMap;
import java.util.Map;

@Service
public class CountryLocatorService {
    

    private Map<String, Geometry> countryGeometries;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("countries.geojson");
        InputStream inputStream = resource.getInputStream();
        FeatureCollection featureCollection = objectMapper.readValue(inputStream, FeatureCollection.class);

        countryGeometries = new HashMap<>();
        for (Feature feature : featureCollection.getFeatures()) {
            countryGeometries.put(feature.getProperties().getISO_A2(), feature.getGeometry());
        }
    }

    public String getCountryCode(double latitude, double longitude) {
        // Iterate over the country geometries to find the matching country for the given coordinates
        for (Map.Entry<String, Geometry> entry : countryGeometries.entrySet()) {
            Geometry geometry = entry.getValue();
            // Assuming the first element of the coordinates array is the outer boundary
            List<List<List<List<Double>>>> coordinates = geometry.getCoordinates();
            if (isPointInsidePolygon(latitude, longitude, coordinates)) {
                return entry.getKey(); // Return the ISO 3166-1 alpha-2 country code
            }
        }
        // Return null if no matching country is found
        return null;
    }

    // Helper method to determine if a point (latitude, longitude) is inside a polygon
    private boolean isPointInsidePolygon(double latitude, double longitude, List<List<List<List<Double>>>> coordinates) {
        int intersectCount = 0;
        for (List<List<List<Double>>> polygon : coordinates) {
            for (List<List<Double>> ring : polygon) {
                for (int i = 0, j = ring.size() - 1; i < ring.size(); j = i++) {
                    if ((ring.get(i).get(1) > latitude) != (ring.get(j).get(1) > latitude) &&
                            (longitude < (ring.get(j).get(0) - ring.get(i).get(0)) * (latitude - ring.get(i).get(1)) /
                                    (ring.get(j).get(1) - ring.get(i).get(1)) + ring.get(i).get(0))) {
                        intersectCount++;
                    }
                }
            }
        }
        return (intersectCount % 2) == 1;
    }
}
