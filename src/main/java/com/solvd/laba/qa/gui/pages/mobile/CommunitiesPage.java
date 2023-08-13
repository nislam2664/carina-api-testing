package com.solvd.laba.qa.gui.pages.mobile;

import com.solvd.laba.qa.gui.pages.common.*;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CommunitiesPageBase.class)
public class CommunitiesPage extends CommunitiesPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final ExtendedWebElement searchBar = getHeader().getSearchBar();

    @FindBy(xpath = "//*[@id=\"top\"]/div/div[2]/a")
    private List<ExtendedWebElement> communityLettersList;

    @FindBy(xpath = "//div/a[@class=\"community-link\"]")
    private List<ExtendedWebElement> communityList;

    private final JavascriptExecutor js = (JavascriptExecutor) driver;
    private ExtendedWebElement chosenSubreddit;

    public CommunitiesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickCommunityThatStartWith(String letter) {
        for (ExtendedWebElement tab : communityLettersList)
            if (tab.getText().equals(letter)) {
                tab.click();
                break;
            }
    }

    @Override
    public void scrollToCommunity(String subreddit) {
        for (ExtendedWebElement name : communityList) {
            chosenSubreddit = name;
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", name.getElement());
            if (name.getText().equals(subreddit))
                break;
        }
    }

    @Override
    public SubredditPageBase clickCommunity() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", chosenSubreddit.getElement());
        return initPage(driver, SubredditPageBase.class);
    }
}
