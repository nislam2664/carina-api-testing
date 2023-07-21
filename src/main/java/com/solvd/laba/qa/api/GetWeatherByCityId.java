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

@Endpoint(url = "${base_url}/data/2.5/weather?id=${city_id}&appid=${api_key}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api_weather/_get/_current_weather/valid_rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetWeatherByCityId extends AbstractApiMethodV2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public GetWeatherByCityId() {
        Properties properties = new Properties();
        String weatherFile = "src/test/resources/api_weather/weather.properties";

        try (FileInputStream fis = new FileInputStream(weatherFile)) {
            properties.load(fis);
        } catch (IOException e) {
            LOGGER.error("Could not find " + weatherFile + " ...");
            LOGGER.error(e.toString());
        }

        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("city_id", properties.getProperty("city_id"));
        replaceUrlPlaceholder("api_key", properties.getProperty("api_key"));
    }

}