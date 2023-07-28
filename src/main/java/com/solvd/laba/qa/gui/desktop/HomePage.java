package com.solvd.laba.qa.gui.desktop;

import com.solvd.laba.qa.gui.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[@aria-label=\"Home\"]")
    private ExtendedWebElement homeLogo;

    @FindBy(xpath = "//button[text()=\"Join Reddit\")]")
    private ExtendedWebElement joinButton;

    @FindBy(xpath = "//a[@role=\"button\"]")
    //@FindBy(xpath = "//a[@id=\"login-button\"]")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = "//a[@id=\"focus-Popular\"]")
    private ExtendedWebElement popularButton;

    @FindBy(xpath = "//button[@id=\"USER_DROPDOWN_ID\"]")
    private ExtendedWebElement userIdButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LogInPopUp getLogIn() {
        logInButton.click();
        return new LogInPopUp(driver);
    }

    @Override
    public void open() {
        super.open();
        LOGGER.info("Home is being opened");
    }

    public boolean isOpen() {
        LOGGER.info("Checking if page is open");
        return homeLogo.isElementPresent();
    }

    public boolean isLoggedIn() {
        return userIdButton.clickIfPresent();
    }
}
