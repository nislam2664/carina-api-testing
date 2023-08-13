package com.solvd.laba.qa.gui.pages.desktop;

import com.solvd.laba.qa.gui.pages.common.SearchResultPageBase;
import com.solvd.laba.qa.gui.pages.common.SubredditPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SearchResultPageBase.class)
public class SearchResultPage extends SearchResultPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(tagName = "reddit-feed")
    private ExtendedWebElement redditFeed;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
}
