package com.solvd.laba.qa.gui.common;

import com.solvd.laba.qa.gui.desktop.LogInPopUp;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract LogInPopUp getLogIn();

    @Override
    public void open() {
        super.open();
    }
}
