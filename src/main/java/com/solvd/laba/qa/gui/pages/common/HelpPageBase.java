package com.solvd.laba.qa.gui.pages.common;

import com.solvd.laba.qa.gui.components.RedditHelpItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class HelpPageBase extends RedditAbstractPage {

    @FindBy(xpath = "//img[@class=\"hero-inner-image\"]")
    protected ExtendedWebElement redditHelpImage;

    @FindBy(xpath = "//input[@name=\"query\"]")
    protected ExtendedWebElement searchBar;

    public HelpPageBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(redditHelpImage);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public void hitEnter() {
        searchBar.sendKeys(Keys.ENTER);
    }

    public abstract void chooseHelpItem(RedditHelpItem helpItem);
    public abstract void writeInSearchBar(String input);
}
