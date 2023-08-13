package com.solvd.laba.qa.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.time.Duration;

public class Header extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//hui-left-nav-see-more[@more-noun=\"resources_menu_see_more\"]")
    private ExtendedWebElement seeMoreButtonMobile;

    @FindBy(id = "navbar-menu-button")
    private ExtendedWebElement navMenuButton;

    @FindBy(xpath = "//a[@aria-label=\"Home\"]")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//button[@id=\"expand-search-button\"]")
    private ExtendedWebElement searchIcon;

    @FindBy(xpath = "//*[@type=\"search\"]")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//button[@id=\"get-app\"]")
    private ExtendedWebElement getAppButton;

    @FindBy(xpath = "//a[@id=\"login-button\"]")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = "//reddit-header-small/header/nav/div[2]/div")
    private ExtendedWebElement useAppButton;

    @FindBy(xpath = "//a[@href=\"https://www.reddit.com/login/?dest=https%3A%2F%2Fwww.reddit.com/subreddits/a-1/\"]")
    private ExtendedWebElement newLogInButton;

    public Header(WebDriver driver) {
        super(driver);
    }

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getLogo() {
        return logo;
    }

    public ExtendedWebElement getSearchBar() {
        return searchBar;
    }

    public void clickNavMenuButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", navMenuButton.getElement());
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(seeMoreButtonMobile.getElement()));
    }

    public void clickLogo() {
        LOGGER.info("Clicking logo to go to home page");
        getLogo().hover();
        getLogo().click();
    }

    public void clickGetApp() {
        LOGGER.info("Clicking 'Get App' button");
        getAppButton.click();
    }

    public void clickLogIn() {
        LOGGER.info("Clicking 'Log In' button");
        logInButton.click();
    }

    public void clickNewLogIn() {
        LOGGER.info("Clicking 'Log In' button");
        newLogInButton.click();
    }

    public boolean isNavMenuButtonExist() {
        return navMenuButton.isPresent();
    }

    public boolean isLogoExist() {
        LOGGER.info("Checking if logo exists...");
        return getLogo().isPresent();
    }

    public boolean isUseAppButtonExist() {
        LOGGER.info("Checking if 'Use App' button exists...");
        return useAppButton.isPresent();
    }

    public boolean isSearchIconExist() {
        LOGGER.info("Checking if search expand icon exists...");
        return searchIcon.isPresent();
    }

    public boolean isSearchBarExist() {
        LOGGER.info("Checking if search bar exists...");
        return searchBar.isPresent();
    }

    public boolean isGetAppButtonExist() {
        LOGGER.info("Checking if 'Get App' button exists...");
        return getAppButton.isPresent();
    }

    public boolean isLogInButtonExist() {
        LOGGER.info("Checking if 'Log In' button exists...");
        return logInButton.isPresent();
    }
}
