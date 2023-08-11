package com.solvd.laba.qa.gui.pages.desktop;

import com.solvd.laba.qa.gui.pages.common.SearchResultPageBase;
import com.solvd.laba.qa.gui.pages.common.SubredditPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SearchResultPageBase.class)
public class SearchResultPage extends SearchResultPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//h1[@id=\"search-results-header\"]")
    private ExtendedWebElement searchResultHeader;

    @FindBy(xpath = "//a[@slot=\"posts\"]")
    private ExtendedWebElement postsButton;

    @FindBy(xpath = "//a[@slot=\"comments\"]")
    private ExtendedWebElement commentsButton;

    @FindBy(xpath = "//a[@slot=\"communities\"]")
    private ExtendedWebElement communitiesButton;

    @FindBy(xpath = "//a[@slot=\"people\"]")
    private ExtendedWebElement peopleButton;

    private List<WebElement> communitiesResults;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isSearchResults() {
        return searchResultHeader.isPresent();
    }

    @Override
    public void clickPosts() {
        postsButton.hover();
        postsButton.click();
    }

    @Override
    public void clickComments() {
        commentsButton.hover();
        commentsButton.click();
    }

    @Override
    public List<WebElement> clickCommunities() {
        communitiesButton.hover();
        communitiesButton.click();
        WebElement redditFeed = driver.findElement(By.tagName("reddit-feed"));
        communitiesResults = redditFeed.findElements(By.xpath("//faceplate-tracker[@data-testid=\"search-community-icon-link-tracker\"]"));
        return communitiesResults;
    }

    @Override
    public SubredditPageBase goToSubreddit(String subreddit, List<WebElement> communitiesList) {
        for (WebElement community : communitiesList)
            if (community.getText().equals(subreddit)) {
                community.click();
                break;
            }

        return initPage(driver, SubredditPageBase.class);
    }

    @Override
    public void clickPeople() {
        peopleButton.hover();
        peopleButton.click();
    }
}
