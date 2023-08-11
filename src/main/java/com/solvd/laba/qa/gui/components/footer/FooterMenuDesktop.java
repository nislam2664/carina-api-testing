package com.solvd.laba.qa.gui.components.footer;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterMenuDesktop extends FooterMenuBase {
    @FindBy(xpath = "//a[@href=\"https://www.redditinc.com\"]")
    private ExtendedWebElement aboutButton;

    @FindBy(xpath = "//a[@href=\"https://www.reddithelp.com\"]")
    private ExtendedWebElement helpButton;

    @FindBy(xpath = "//reddit-sidebar-nav-see-more[@class=\"col-span-4\"]")
    private ExtendedWebElement seeMoreButton;

    @FindBy(xpath = "//a[@href=\"https://www.reddit.com/subreddits/a-1/\"]")
    private ExtendedWebElement communitiesButton;

    public FooterMenuDesktop(WebDriver driver) {
        super(driver);
    }

    public FooterMenuDesktop(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void openAboutPage() {
        aboutButton.scrollTo();
        aboutButton.hover();
        aboutButton.click();
    }

    @Override
    public void openHelpPage() {
        helpButton.scrollTo();
        helpButton.hover();
        helpButton.click();
    }

    @Override
    public void openCommunitiesPage() {
        seeMoreButton.scrollTo();
        seeMoreButton.hover();
        seeMoreButton.click();
        communitiesButton.scrollTo();
        communitiesButton.hover();
        communitiesButton.click();
    }
}
