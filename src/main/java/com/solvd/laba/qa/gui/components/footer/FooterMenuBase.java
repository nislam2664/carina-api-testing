package com.solvd.laba.qa.gui.components.footer;

import com.solvd.laba.qa.gui.pages.common.AboutPageBase;
import com.solvd.laba.qa.gui.pages.common.CommunitiesPageBase;
import com.solvd.laba.qa.gui.pages.common.HelpPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class FooterMenuBase extends AbstractUIObject {

    public FooterMenuBase(WebDriver driver) {
        super(driver);
    }

    public FooterMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void openAboutPage();
    public abstract void openHelpPage();
    public abstract void openCommunitiesPage();
}
