package com.solvd.laba.qa.gui.common;

import com.solvd.laba.qa.gui.desktop.HomePage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public abstract class LogInPopUpBase extends AbstractUIObject {

    public LogInPopUpBase(WebDriver driver) {
        super(driver);
    }

    public abstract void writeUsername(String uname);
    public abstract void writePassword(String pass);
    public abstract HomePage clickLogIn();
}
