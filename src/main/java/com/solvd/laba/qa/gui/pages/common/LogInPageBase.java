package com.solvd.laba.qa.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class LogInPageBase extends RedditAbstractPage {
    @FindBy(xpath = "//button[@type=\"submit\"]")
    protected ExtendedWebElement submitButton;

    public LogInPageBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(submitButton);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract void writeUsername(String username);
    public abstract void writePassword(String password);
    public abstract void clickSubmit();
}
