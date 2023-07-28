package com.solvd.laba.qa.gui.desktop;

import com.solvd.laba.qa.gui.common.HomePageBase;
import com.solvd.laba.qa.gui.common.LogInPopUpBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LogInPopUpBase.class)
public class LogInPopUp extends LogInPopUpBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//main[@class=\"Login\"]")
    private ExtendedWebElement popUpWindow;

    @FindBy(xpath = "//a[@class=\"BottomLink m-modalUpdate bold \"]")
    private ExtendedWebElement logInHyperLink;

    @FindBy(xpath = "//input[@id=\"loginUsername\"]")
    private ExtendedWebElement usernameText;

    @FindBy(xpath = "//input[@id=\"loginPassword\"]")
    private ExtendedWebElement passwordText;

    @FindBy(xpath = "//button[@class=\"AnimatedForm_submitButton m-full-width m-modalUpdate\"]")
    private ExtendedWebElement logInButton;

    public LogInPopUp(WebDriver driver) {
        super(driver);
    }

    public void chooseLogIn() {
        driver.findElement(By.xpath("//a[@class=\"BottomLink m-modalUpdate bold \"]")).click();
    }

    @Override
    public void writeUsername(String uname) {
        usernameText.type(uname);
    }

    @Override
    public void writePassword(String pass) {
        passwordText.type(pass);
    }

    public HomePage clickLogIn() {
        logInButton.click();
        return new HomePage(driver);
    }
}
