package com.solvd.laba.qa.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class SearchResultPageBase extends AbstractPage {
    public SearchResultPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isSearchResults();
    public abstract void clickPosts();
    public abstract void clickComments();
    public abstract List<WebElement> clickCommunities();
    public abstract SubredditPageBase goToSubreddit(String subreddit, List<WebElement> communitiesList);
    public abstract void clickPeople();
}
