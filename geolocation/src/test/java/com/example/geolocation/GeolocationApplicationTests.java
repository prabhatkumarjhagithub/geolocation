package com.example.geolocation;

import com.example.geolocation.service.CountryLocatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GeolocationApplicationTests {
	@Autowired
	private CountryLocatorService countryLocatorService;

	@BeforeEach
	public void setup() throws IOException {
		countryLocatorService.init();
	}
	/**
	 * Tests for valid, edge cases, invalid, ocean, pole, dateline, equator, and multiple country boundary coordinates.
	 */
	@Test
	public void testValidCoordinates() {
		assertEquals("US", countryLocatorService.getCountryCode(37.7749, -122.4194));
		assertEquals("IN", countryLocatorService.getCountryCode(28.6139, 77.2090));
	}

	@Test
	public void testEdgeCasesOnCountryBoundary() {
		assertEquals("NP", countryLocatorService.getCountryCode(27.771942, 82.305073));
		assertEquals("FR", countryLocatorService.getCountryCode(48.999, 7.599));
	}

	@Test
	public void testInvalidCoordinates() {
		assertEquals(null, countryLocatorService.getCountryCode(999, -122.4194));
		assertEquals(null, countryLocatorService.getCountryCode(37.7749, 999));
		assertEquals(null, countryLocatorService.getCountryCode(999, 999));
	}

	@Test
	public void testOceanCoordinates() {
		assertEquals(null, countryLocatorService.getCountryCode(0, -160));
		assertEquals(null, countryLocatorService.getCountryCode(0, -30));
	}

	@Test
	public void testPoleCoordinates() {
		assertEquals(null, countryLocatorService.getCountryCode(90, 0));
		assertEquals(null, countryLocatorService.getCountryCode(-90, 0));
	}

	@Test
	public void testCoordinatesOnDateline() {
		assertEquals(null, countryLocatorService.getCountryCode(0, 180));
		assertEquals(null, countryLocatorService.getCountryCode(0, -180));
	}

	@Test
	public void testCoordinatesOnEquator() {
		assertEquals("CD", countryLocatorService.getCountryCode(0, 25));
		assertEquals("ID", countryLocatorService.getCountryCode(0, 120));
	}

	@Test
	public void testMultipleCountryBoundaries() {
		assertEquals("DE", countryLocatorService.getCountryCode(50.756, 6.073));
	}
}

