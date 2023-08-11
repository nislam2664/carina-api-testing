package com.solvd.laba.qa.gui.components.header;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderMenuBase extends AbstractUIObject {

    public HeaderMenuBase(WebDriver driver) {
        super(driver);
    }

    public HeaderMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void clickHomeLogo();
    public abstract void openGetApp();
    public abstract void openLogIn();
}
