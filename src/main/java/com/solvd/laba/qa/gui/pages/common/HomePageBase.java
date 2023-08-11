package com.solvd.laba.qa.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    // HEADER MENU
    public abstract LogInPageBase openLogIn();
    public abstract GetAppPopUpBase openGetApp();

    // FOOTER MENU
    public abstract AboutPageBase openAboutPage();
    public abstract HelpPageBase openHelpPage();
    public abstract CommunitiesPageBase openCommunitiesPage();
    public abstract ProfilePageBase upvotePost();

    public abstract void clickBackToTop();
    public abstract void selectAPost();
    public abstract void writeComment();
    public abstract boolean isHomeLogoExist();
    public abstract boolean isUserDropdownExist();
    public abstract boolean isCreatePostVisible();

    @Override
    public void open() {
        super.open();
    }
}
