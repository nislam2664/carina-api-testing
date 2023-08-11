package com.solvd.laba.qa.gui.pages.desktop;

import com.solvd.laba.qa.gui.pages.common.CommunitiesPageBase;
import com.solvd.laba.qa.gui.pages.common.HomePageBase;
import com.solvd.laba.qa.gui.pages.common.SearchResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CommunitiesPageBase.class)
public class CommunitiesPage extends CommunitiesPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[@href=\"https://www.reddit.com/login/?dest=https%3A%2F%2Fwww.reddit.com/subreddits/a-1/\"]")
    private ExtendedWebElement logInButton;

    @FindBy(className = "user-button")
    private ExtendedWebElement userButton;

    @FindBy(xpath = "//input[@name=\"q\"]")
    private ExtendedWebElement searchBar;

    public CommunitiesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickLogIn() {
        logInButton.click();
    }

    @Override
    public HomePageBase returnToHomePage() {
        userButton.click(500);
        WebElement logInSignUpButton = driver.findElement(By.xpath("//a[@href=\"https://www.reddit.com/?dest=https%3A%2F%2Fwww.reddit.com/subreddits/a-1/\"]"));
        logInSignUpButton.click();
        return initPage(driver, HomePageBase.class);
    }

    @Override
    public SearchResultPageBase searchInSearchBar(String input)  {
        LOGGER.info("Writing text into search bar");
        searchBar.hover();
        searchBar.click();
        searchBar.type(input);
        searchBar.sendKeys(Keys.ENTER);
        return initPage(driver, SearchResultPageBase.class);
    }
}
