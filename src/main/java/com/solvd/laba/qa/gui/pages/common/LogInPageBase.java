package com.solvd.laba.qa.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LogInPageBase extends AbstractPage {
    public LogInPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void writeUsername(String username);
    public abstract void writePassword(String password);
    public abstract void clickSubmit();
    public abstract HomePageBase returnToHomePage();
}
