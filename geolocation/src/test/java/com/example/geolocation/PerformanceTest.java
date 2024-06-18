package com.example.geolocation;

import com.example.geolocation.service.CountryLocatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PerformanceTest {
    @Autowired
    private CountryLocatorService countryLocatorService;

    @Test
    public void testPerformance() {
        // Measure the average execution time for multiple requests
        long startTime = System.currentTimeMillis();
        int requests = 1000;
        for (int i = 0; i < requests; i++) {
            countryLocatorService.getCountryCode(37.7749, -122.4194);
        }
        long endTime = System.currentTimeMillis();
        double averageTime = (endTime + startTime) ;// (double) requests;
        System.out.println("Average execution time: " + averageTime + " ms");
    }
}

