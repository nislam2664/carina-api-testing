package com.solvd.laba.qa.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public abstract class HomePageBase extends RedditAbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public HomePageBase(WebDriver driver) {
        super(driver);
        LOGGER.info("Retrieving page URL");
        setUiLoadedMarker(getHeader().getLogo());
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public void clickNavMenuButton() {
        getHeader().clickNavMenuButton();
    }

    public HelpPageBase clickHelp() {
        getSidebar().clickHelp();
        return initPage(driver, HelpPageBase.class);
    }

    public CommunitiesPageBase clickCommunities() {
        getSidebar().clickCommunities();
        return initPage(driver, CommunitiesPageBase.class);
    }

    public abstract boolean isPopularCommunitiesSectionExist();
    public abstract void clickSeeMoreResources();
    public abstract void clickSeeMorePopularCommunities();
    public abstract void selectRandomSubreddit();
    public abstract SubredditPageBase clickRandomSubreddit();
    public abstract String getRandomSubredditName();
    public abstract String getRandomSubredditURL();
    public abstract boolean isUserDropdownExist();

    @Override
    public void open() {
        super.open();
    }
}
