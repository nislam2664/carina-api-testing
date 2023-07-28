package com.solvd.laba.qa.gui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Properties;

public class RedditProperties {
    private static Properties properties;
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    static {
        initialize();
    }

    public static void initialize() {
        properties = new Properties();
        String redditFile = "src/test/resources/gui/reddit.properties";

        try (FileInputStream fis = new FileInputStream(redditFile)) {
            properties.load(fis);
        } catch (IOException e) {
            LOGGER.error("Could not find " + redditFile + " ...");
            LOGGER.error(e.toString());
        }
    }

    public static Properties getProperties() {
        return properties;
    }
}
