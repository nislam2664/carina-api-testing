package com.solvd.laba.qa.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public abstract class SearchResultPageBase extends RedditAbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//h1[@id=\"search-results-header\"]")
    protected ExtendedWebElement searchResultHeader;

    @FindBy(xpath = "//a[@slot=\"posts\"]")
    protected ExtendedWebElement postsButton;

    @FindBy(xpath = "//a[@slot=\"communities\"]")
    protected ExtendedWebElement communitiesButton;

    @FindBy(xpath = "//a[@slot=\"people\"]")
    protected ExtendedWebElement peopleButton;

    @FindBy(xpath = "//reddit-feed/faceplate-tracker/div/div/faceplate-tracker[@data-testid=\"search-community-icon-link-tracker\"]")
    private List<ExtendedWebElement> resultsList;

    public SearchResultPageBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(searchResultHeader);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public void clickPostsTab() {
        postsButton.hover();
        postsButton.click();
    }

    public void clickCommunitiesTab() {
        communitiesButton.hover();
        communitiesButton.click();
    }

    public void clickPeopleTab() {
        peopleButton.hover();
        peopleButton.click();
    }

    public SubredditPageBase clickSubreddit(String subreddit) {
        for (ExtendedWebElement community : resultsList)
            if (community.getText().equals(subreddit)) {
                community.click();
                break;
            }
        return initPage(driver, SubredditPageBase.class);
    }
}
