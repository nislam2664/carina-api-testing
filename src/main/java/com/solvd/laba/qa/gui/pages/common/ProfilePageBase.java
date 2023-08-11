package com.solvd.laba.qa.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProfilePageBase extends AbstractPage {
    public ProfilePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void viewUpvoted();
    public abstract boolean isNavigationDropdownExist();
}
