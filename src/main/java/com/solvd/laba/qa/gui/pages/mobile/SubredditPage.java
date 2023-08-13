package com.solvd.laba.qa.gui.pages.mobile;

import com.solvd.laba.qa.gui.pages.common.SubredditPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SubredditPageBase.class)
public class SubredditPage extends SubredditPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//shreddit-join-button")
    private ExtendedWebElement joinButton;

    @FindBy(xpath = "//shreddit-app/div/div[2]/div[1]/div[1]/span/a")
    private ExtendedWebElement aboutTab;

    @FindBy(xpath = "//section[3]/div/div[1]/h2")
    private ExtendedWebElement rulesSection;

    @FindBy(xpath = "//section[1]/div/shreddit-subreddit-header")
    private ExtendedWebElement description;

    public SubredditPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isJoinButtonExist() {
        return joinButton.isPresent();
    }

    @Override
    public boolean isAboutTabExist() {
        return aboutTab.isPresent();
    }

    @Override
    public void clickAboutTab() {
        aboutTab.click();
    }

    @Override
    public boolean isRulesSectionExist() {
        return rulesSection.isPresent();
    }

    @Override
    public String getSubredditDescription() {
       return description.getAttribute("description");
    }
}
