package com.solvd.laba.qa.gui.pages.common;

import com.solvd.laba.qa.gui.components.enums.RedditHelpItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HelpPageBase extends AbstractPage {
    public HelpPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void chooseHelpItem(RedditHelpItem helpItem) throws InterruptedException;
    public abstract boolean isCorrectHeader(RedditHelpItem helpItem);
    public abstract void writeInSearchBar(String input) throws InterruptedException;
}
