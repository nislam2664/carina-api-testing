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

@Endpoint(url = "${base_url}/${data_ver}/weather?id=${city_id}&appid=${api_key}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetWeatherByCityId extends AbstractApiMethodV2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public GetWeatherByCityId(int id) {
        Properties properties = WeatherProperties.getProperties();

        replaceUrlPlaceholder("base_url", Configuration.getRequired("base_url"));
        replaceUrlPlaceholder("data_ver", Configuration.getRequired("data_ver"));
        replaceUrlPlaceholder("api_key", Configuration.getRequired("key"));
        replaceUrlPlaceholder("city_id", String.valueOf(id));
        LOGGER.info("URL placeholder replacement successful");
    }

}