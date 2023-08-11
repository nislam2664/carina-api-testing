package com.solvd.laba.qa.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SubredditPageBase extends AbstractPage {
    public SubredditPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getSubredditName();
}
