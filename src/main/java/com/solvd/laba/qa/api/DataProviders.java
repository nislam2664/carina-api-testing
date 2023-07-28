package com.solvd.laba.qa.api;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class DataProviders {
    private static final Object[][] data = {
            {"New York", 5128581, 40.7143, -74.0060},
            {"London", 2643743, 51.5085, -0.1257},
            {"Tokyo", 1850147, 35.6895, 139.6917},
            {"Barcelona", 3128760, 41.3888, 2.159},
            {"Minsk City", 625144, 53.9, 27.5667}
    };

    @DataProvider(name = "city names")
    public static Object[] getCityName() {
        return Arrays.stream(data).map(datum -> datum[0]).toArray();
    }

    @DataProvider(name = "city ids")
    public static Object[] getCityIds() {
        return Arrays.stream(data).map(datum -> datum[1]).toArray();
    }

    @DataProvider(name = "coords")
    public static Object[][] getCoords() {
        Object[] lats = Arrays.stream(data).map(datum -> datum[2]).toArray();
        Object[] lons = Arrays.stream(data).map(datum -> datum[3]).toArray();

        Object[][] coords = new Object[lats.length][2];

        for(int i = 0; i < coords.length; i++) {
            coords[i][0] = lats[i];
            coords[i][1] = lons[i];
        }

        return coords;
    }
}
