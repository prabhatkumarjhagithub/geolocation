package com.example.geolocation.model;

import java.util.List;

public class Boundary {
    private List<List<List<Double>>> coordinates;

    public List<List<List<Double>>> getCoordinates() {

        return coordinates;
    }

    public void setCoordinates(List<List<List<Double>>> coordinates) {

        this.coordinates = coordinates;
    }

public boolean contains(double latitude, double longitude) {
    // Iterate through each polygon in the coordinates list
    for (List<List<Double>> polygon : coordinates) {
        // Check if the point is inside the current polygon
        if (isPointInPolygon(latitude, longitude, polygon)) {
            return true;
        }
    }
    return false;
}

private boolean isPointInPolygon(double latitude, double longitude, List<List<Double>> polygon) {
    int numIntersections = 0;
    int numVertices = polygon.size();

    // Iterate through each edge of the polygon
    for (int i = 0; i < numVertices; i++) {
        List<Double> vertex1 = polygon.get(i);
        List<Double> vertex2 = polygon.get((i + 1) % numVertices);

        double lat1 = vertex1.get(1);
        double lon1 = vertex1.get(0);
        double lat2 = vertex2.get(1);
        double lon2 = vertex2.get(0);

        // Check if the point intersects with the edge
        if (((lat1 > latitude) != (lat2 > latitude)) &&
                (longitude < (lon2 - lon1) * (latitude - lat1) / (lat2 - lat1) + lon1)) {
            numIntersections++;
        }
    }

    // Return true if the number of intersections is odd
    return (numIntersections % 2 == 1);
}

}
