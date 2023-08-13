package com.solvd.laba.qa.gui.pages.mobile;

import com.solvd.laba.qa.gui.pages.common.SearchResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchResultPageBase.class)
public class SearchResultPage extends SearchResultPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
}
