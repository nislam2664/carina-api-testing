package com.solvd.laba.qa.gui.components.header;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuDesktop extends HeaderMenuBase {
    @FindBy(xpath = "//a[@aria-label=\"Home\"]")
    private ExtendedWebElement homeLogo;

    @FindBy(xpath = "//a[@id=\"get-app\"]")
    private ExtendedWebElement getAppButton;

    @FindBy(xpath = "//a[@id=\"login-button\"]")
    private ExtendedWebElement logInButton;

    public HeaderMenuDesktop(WebDriver driver) {
        super(driver);
    }

    public HeaderMenuDesktop(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void clickHomeLogo() {
        homeLogo.hover();
        homeLogo.click();
    }

    @Override
    public void openGetApp() {
        getAppButton.click();
    }

    @Override
    public void openLogIn() {
        logInButton.click();
    }
}
