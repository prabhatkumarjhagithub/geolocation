# Country Locator

This Spring Boot application accepts latitude and longitude as input and returns the country code in ISO 3166-1 alpha-2 format.

## Features
- Determine country code based on latitude and longitude without external API calls.
- Uses offline GeoJSON file containing country boundaries.
- Includes unit tests and performance tests.

## Setup
1. Place your GeoJSON file containing country boundaries in the specified path.
2. Update `application.properties` with the path to the GeoJSON file.
3. Build and run the application.

## Endpoints
- `GET /getCountryCode?latitude={latitude}&longitude={longitude}`: Returns the country code for the specified coordinates.

## Running Tests
- Unit tests: `mvn test`
- Performance test: Included in the `PerformanceTest` class.

## Dependencies
- Spring Boot
- Jackson Databind

## How It Works
- The application loads country boundaries from a GeoJSON file during initialization.
- The `getCountryCode` method uses the Ray-Casting algorithm to determine if a point is inside a country's boundaries.
