package com.solvd.laba.qa.gui.pages.desktop;

import com.solvd.laba.qa.gui.pages.common.LogInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LogInPageBase.class)
public class LogInPage extends LogInPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//input[@id=\"loginUsername\"]")
    private ExtendedWebElement usernameInput;

    @FindBy(xpath = "//input[@id=\"loginPassword\"]")
    private ExtendedWebElement passwordInput;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void writeUsername(String username) {
        usernameInput.hover();
        usernameInput.click();
        usernameInput.type(username, 200);
    }

    @Override
    public void writePassword(String password) {
        passwordInput.hover();
        passwordInput.click();
        passwordInput.type(password, 200);
    }

    @Override
    public void clickSubmit() {
        submitButton.click();
    }
}
