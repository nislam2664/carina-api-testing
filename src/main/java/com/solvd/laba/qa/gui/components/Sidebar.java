package com.solvd.laba.qa.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class Sidebar extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[@href=\"https://www.reddithelp.com\"]")
    private ExtendedWebElement helpButton;

    @FindBy(xpath = "//reddit-sidebar-nav-see-more[@class=\"col-span-4\"]")
    private ExtendedWebElement seeMoreButton;

    @FindBy(xpath = "//hui-left-nav-see-more[@more-noun=\"resources_menu_see_more\"]")
    private ExtendedWebElement seeMoreButtonMobile;

    @FindBy(xpath = "//a[@href=\"https://www.reddit.com/subreddits/a-1/\"]")
    private ExtendedWebElement communitiesButton;

    public Sidebar(WebDriver driver) {
        super(driver);
    }

    public Sidebar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickHelp() {
        LOGGER.info("Clicking 'Help' button");
        helpButton.scrollTo();
        helpButton.hover();
        helpButton.click();
    }

    public void clickSeeMore() {
        LOGGER.info("Clicking 'See More' button under 'Resources'");
        seeMoreButton.scrollTo();
        seeMoreButton.hover();
        seeMoreButton.click(1000);
    }

    public void clickSeeMoreMobile() {
        LOGGER.info("Clicking 'See More' button under 'Resources'");
        seeMoreButtonMobile.scrollTo();
        seeMoreButtonMobile.hover();
        seeMoreButtonMobile.click();
    }

    public void clickCommunities() {
        LOGGER.info("Clicking 'Communities' button");
        communitiesButton.scrollTo();
        communitiesButton.hover();
        communitiesButton.click();
    }

    public boolean isHelpButtonExist() {
        LOGGER.info("Checking if 'Help' button exists...");
        return helpButton.isPresent();
    }

    public boolean isSeeMoreButtonExist() {
        LOGGER.info("Checking if 'See More' button exists...");
        return seeMoreButton.isPresent();
    }

    public boolean isCommunitiesButtonExist() {
        LOGGER.info("Checking if 'Communities' button exists...");
        return communitiesButton.isPresent();
    }
}
