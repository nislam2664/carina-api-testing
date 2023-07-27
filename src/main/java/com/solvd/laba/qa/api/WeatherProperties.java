package com.solvd.laba.qa.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Properties;

public class WeatherProperties {
    private static Properties properties;
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    static {
        initialize();
    }

    public static void initialize() {
        properties = new Properties();
        String weatherFile = "src/test/resources/api/weather.properties";

        try (FileInputStream fis = new FileInputStream(weatherFile)) {
            properties.load(fis);
        } catch (IOException e) {
            LOGGER.error("Could not find " + weatherFile + " ...");
            LOGGER.error(e.toString());
        }
    }

    public static Properties getProperties() {
        return properties;
    }
}
