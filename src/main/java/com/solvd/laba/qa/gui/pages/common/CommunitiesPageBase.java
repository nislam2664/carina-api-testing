package com.solvd.laba.qa.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CommunitiesPageBase extends AbstractPage {
    public CommunitiesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickLogIn();
    public abstract HomePageBase returnToHomePage();
    public abstract SearchResultPageBase searchInSearchBar(String input);
}
