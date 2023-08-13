package com.solvd.laba.qa.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public abstract class CommunitiesPageBase extends RedditAbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class=\"title\"]")
    private ExtendedWebElement title;

    private final ExtendedWebElement searchBar = getHeader().getSearchBar();

    public CommunitiesPageBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public LogInPageBase clickLogIn() {
        getHeader().clickNewLogIn();
        return initPage(driver, LogInPageBase.class);
    }

    public HomePageBase clickLogo() {
        getHeader().clickLogo();
        return initPage(driver, HomePageBase.class);
    }

    public void searchInSearchBar(String input)  {
        LOGGER.info("Writing text into search bar");
        searchBar.hover();
        searchBar.click();
        searchBar.type(input);
    }

    public SearchResultPageBase hitEnter() {
        searchBar.sendKeys(Keys.ENTER);
        return initPage(driver, SearchResultPageBase.class);
    }

    public abstract void clickCommunityThatStartWith(String letter);
    public abstract void scrollToCommunity(String subreddit);
    public abstract SubredditPageBase clickCommunity();
}
