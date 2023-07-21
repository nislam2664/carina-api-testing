package com.solvd.laba.qa.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Properties;

@Endpoint(url = "${base_url}/geo/1.0/zip?zip=${zip_code},${country_code}&appid=${api_key}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api_weather/_get/_geocoding/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetGeocodeByZip extends AbstractApiMethodV2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public GetGeocodeByZip() {
        Properties properties = new Properties();
        String weatherFile = "src/test/resources/api_weather/weather.properties";

        try (FileInputStream fis = new FileInputStream(weatherFile)) {
            properties.load(fis);
        } catch (IOException e) {
            LOGGER.error("Could not find " + weatherFile + " ...");
            LOGGER.error(e.toString());
        }

        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("zip_code", properties.getProperty("zip_code"));
        replaceUrlPlaceholder("country_code", properties.getProperty("country_code"));
        replaceUrlPlaceholder("api_key", properties.getProperty("api_key"));
    }
}
