package com.solvd.laba.qa.api_test;

import com.solvd.laba.qa.api.*;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class WeatherAPITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testGetWeatherByCoord() {
        LOGGER.info("[TEST] Get Current Weather by Latitude and Longitude");
        GetWeatherByCoord getWeatherByCoord = new GetWeatherByCoord();
        getWeatherByCoord.callAPIExpectSuccess();
        getWeatherByCoord.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherByCoord.validateResponseAgainstSchema("api_weather/_get/_current_weather/valid_rs.schema");
    }

    @Test
    public void testGetWeatherByInvalidCoord() {
        LOGGER.info("[TEST] Get Current Weather by Invalid Latitude and Longitude");
        GetWeatherByInvalidCoord getWeatherByInvalidCoord = new GetWeatherByInvalidCoord();
        getWeatherByInvalidCoord.callAPIExpectSuccess();
        getWeatherByInvalidCoord.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherByInvalidCoord.validateResponseAgainstSchema("api_weather/_get/_current_weather/invalid_rs.schema");
    }

    @Test
    public void testGetWeatherByCity() {
        LOGGER.info("[TEST] Get Current Weather by City Name");
        GetWeatherByCity getWeatherByCity = new GetWeatherByCity();
        getWeatherByCity.callAPIExpectSuccess();
        getWeatherByCity.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherByCity.validateResponseAgainstSchema("api_weather/_get/_current_weather/valid_rs.schema");
    }

    @Test
    public void testGetWeatherByCityId() {
        LOGGER.info("[TEST] Get Current Weather by City ID");
        GetWeatherByCityId getWeatherByCityId = new GetWeatherByCityId();
        getWeatherByCityId.callAPIExpectSuccess();
        getWeatherByCityId.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherByCityId.validateResponseAgainstSchema("api_weather/_get/_current_weather/valid_rs.schema");
    }

    @Test
    public void testGetWeatherByCityIdArabic() {
        LOGGER.info("[TEST] Get Current Weather by City ID in Arabic");
        GetWeatherByCityIdArabic getWeatherByCityIdArabic = new GetWeatherByCityIdArabic();
        getWeatherByCityIdArabic.callAPIExpectSuccess();
        getWeatherByCityIdArabic.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherByCityIdArabic.validateResponseAgainstSchema("api_weather/_get/_current_weather/arabic_rs.schema");
    }

    @Test
    public void testGetHistoricalAirPollution() {
        LOGGER.info("[TEST] Get Historical Air Pollution");
        GetHistoricalAirPollution getHistoricalAirPollution = new GetHistoricalAirPollution();
        getHistoricalAirPollution.callAPIExpectSuccess();
        getHistoricalAirPollution.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getHistoricalAirPollution.validateResponseAgainstSchema("api_weather/_get/_historical_air_pollution/rs.schema");
    }

    @Test
    public void testGetGeocodeByZip() {
        LOGGER.info("[TEST] Get Geocode by Zip Code");
        GetGeocodeByZip getGeocodeByZip = new GetGeocodeByZip();
        getGeocodeByZip.callAPIExpectSuccess();
        getGeocodeByZip.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getGeocodeByZip.validateResponseAgainstSchema("api_weather/_get/_geocoding/rs.schema");
    }

    @Test
    public void testInvalidAPIKey() {
        LOGGER.info("[TEST] Get Invalid API Key Authorization");
        GetInvalidAPIKey invalidAPIKey = new GetInvalidAPIKey();
        invalidAPIKey.callAPIExpectSuccess();
        invalidAPIKey.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        invalidAPIKey.validateResponseAgainstSchema("api_weather/_get/_api_key_authorization/rs.schema");
    }
}
