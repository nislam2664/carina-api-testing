package com.solvd.laba.qa.gui.pages.common;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class SubredditPageBase extends RedditAbstractPage {

    private String subreddit_description = Configuration.getRequired("subreddit_search");

    @FindBy(xpath = "//div[@class=\"py-md\"]")
    private ExtendedWebElement subredditColumn;

    @FindBy(xpath = "//shreddit-async-loader/div[2]/div[1]/div/div[2]/div[1]")
    private ExtendedWebElement subredditName;

    public SubredditPageBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(subredditColumn);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public String getSubredditName() {
        return subredditName.getText();
    }

    public String getSubredditURL() {
        return getCurrentUrl();
    }

    public abstract boolean isJoinButtonExist();
    public abstract boolean isAboutTabExist();
    public abstract void clickAboutTab();
    public abstract boolean isRulesSectionExist();
    public abstract String getSubredditDescription();
}