package com.solvd.laba.qa.api.get;

import com.solvd.laba.qa.api.WeatherProperties;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Properties;

@Endpoint(url = "${base_url}/${data_ver}/weather?lat=${lat}&lon=${lon}&appid=${api_key}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.BAD_REQUEST_400)
public class GetInvalidCoord extends AbstractApiMethodV2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public GetInvalidCoord() {
        Properties properties = WeatherProperties.getProperties();

        replaceUrlPlaceholder("base_url", Configuration.getRequired("base_url"));
        replaceUrlPlaceholder("data_ver", Configuration.getRequired("data_ver"));
        replaceUrlPlaceholder("api_key", Configuration.getRequired("key"));
        replaceUrlPlaceholder("lat", properties.getProperty("invalid_lat"));
        replaceUrlPlaceholder("lon", properties.getProperty("invalid_lon"));
        LOGGER.info("URL placeholder replacement successful");
    }

}
