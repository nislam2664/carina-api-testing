package com.solvd.laba.qa.gui.pages.mobile;

import com.solvd.laba.qa.gui.pages.common.*;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//section[@class=\"mt-md\"]")
    private ExtendedWebElement popularCommunitiesSection;

    @FindBy(id = "USER_DROPDOWN_ID")
    private ExtendedWebElement userDropdown;

    private ExtendedWebElement randomSubreddit;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPopularCommunitiesSectionExist() {
        return popularCommunitiesSection.isPresent();
    }

    @Override
    public void clickSeeMorePopularCommunities() {
        throw new UnsupportedOperationException("Unused");
    }

    @Override
    public void selectRandomSubreddit() {
        throw new UnsupportedOperationException("Unused");
    }

    @Override
    public SubredditPageBase clickRandomSubreddit() {
        throw new UnsupportedOperationException("Unused");
    }

    @Override
    public String getRandomSubredditName() {
        return randomSubreddit.getText();
    }

    @Override
    public String getRandomSubredditURL() {
        return Configuration.getRequired("base_url") + getRandomSubredditName() + "/";
    }

    @Override
    public void clickSeeMoreResources() {
        getSidebar().clickSeeMoreMobile();
    }

    @Override
    public boolean isUserDropdownExist() {
        return userDropdown.clickIfPresent();
    }

    @Override
    public void open() {
        LOGGER.info("Home page is being opened");
        super.open();
    }
}
