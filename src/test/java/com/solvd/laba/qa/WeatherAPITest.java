package com.solvd.laba.qa;

import com.solvd.laba.qa.api.get.*;
import com.solvd.laba.qa.api.WeatherProperties;
import com.solvd.laba.qa.api.DataProviders;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class WeatherAPITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    @MethodOwner(owner = "nislam")
    public void testGetGeocodeByZip() {
        LOGGER.info("[TEST] Get Geocode by Zip Code");
        GetGeocodeByZip api = new GetGeocodeByZip();
        Response response = api.callAPIExpectSuccess();

        int zip = response.jsonPath().getInt("zip");
        String name = response.jsonPath().getString("name");
        double lat = response.jsonPath().getDouble("lat");
        double lon = response.jsonPath().getDouble("lon");
        String country = response.jsonPath().getString("country");

        Properties properties = WeatherProperties.getProperties();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(zip, Integer.parseInt(properties.getProperty("zip_code")), "Zip code is not as expected.");
        softAssert.assertEquals(name, properties.getProperty("city_name"), "City name is not as expected.");
        softAssert.assertEquals(lat, Double.parseDouble(properties.getProperty("lat")), "Latitude is not as expected.");
        softAssert.assertEquals(lat, Double.parseDouble(properties.getProperty("lat")), "Latitude is not as expected.");
        softAssert.assertEquals(country, properties.getProperty("country_code"), "Country code is not as expected.");

        api.validateResponse();
        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "nislam")
    public void testGetHistoricalAirPollution() {
        LOGGER.info("[TEST] Get Historical Air Pollution");
        GetHistoricalAirPollution api = new GetHistoricalAirPollution();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test(dataProvider = "city ids", dataProviderClass = DataProviders.class)
    @MethodOwner(owner = "nislam")
    public void testGetWeatherByCityId(int id) {
        LOGGER.info("[TEST] Get Current Weather by City ID");
        GetWeatherByCityId api = new GetWeatherByCityId(id);
        Response response = api.callAPIExpectSuccess();
        int idResponse = response.jsonPath().getInt("id");
        assertEquals(id, idResponse, "City id is not as expected.");
    }

    @Test(dataProvider = "city names", dataProviderClass = DataProviders.class)
    @MethodOwner(owner = "nislam")
    public void testGetWeatherByCityName(String name) {
        LOGGER.info("[TEST] Get Current Weather by City Name");
        GetWeatherByCityName api = new GetWeatherByCityName(name);
        Response response = api.callAPIExpectSuccess();
        String nameResponse = response.jsonPath().getString("name");
        assertEquals(name, nameResponse, "City name is not as expected.");
        api.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test(dataProvider = "coords", dataProviderClass = DataProviders.class)
    @MethodOwner(owner = "nislam")
    public void testGetWeatherByCoord(double lat, double lon) {
        LOGGER.info("[TEST] Get Current Weather by Latitude and Longitude");
        GetWeatherByCoord api = new GetWeatherByCoord(lat, lon);
        Response response = api.callAPIExpectSuccess();
        double latResponse = response.jsonPath().getDouble("coord.lat");
        double lonResponse = response.jsonPath().getDouble("coord.lon");
        assertEquals(lat, latResponse, 0.01, "Latitude is not as expected.");
        assertEquals(lon, lonResponse, 0.01,"Longitude is not as expected.");
        api.validateResponseAgainstSchema("api/_get/rs.schema");
    }

    @Test
    @MethodOwner(owner = "nislam")
    public void testInvalidAPIKey() {
        LOGGER.info("[TEST] Get Invalid API Key Authorization");
        GetInvalidAPIKey api = new GetInvalidAPIKey();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test
    @MethodOwner(owner = "nislam")
    public void testInvalidCoord() {
        LOGGER.info("[TEST] Get Invalid Latitude and Longitude");
        GetInvalidCoord api = new GetInvalidCoord();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("api/_get/rs_error.schema");
    }

    @Test
    @MethodOwner(owner = "nislam")
    public void testNullCity() {
        LOGGER.info("[TEST] Get Null City");
        GetNullCity api = new GetNullCity();
        api.callAPIExpectSuccess();
        api.validateResponseAgainstSchema("api/_get/rs_error.schema");
    }
}
