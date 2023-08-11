package com.solvd.laba.qa.gui.pages.desktop;

import com.solvd.laba.qa.gui.pages.common.ProfilePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[contains(@href, \"/upvoted/\")]")
    private ExtendedWebElement upvotedTab;

    @FindBy(xpath = "//div[@role=\"navigation\"]")
    private ExtendedWebElement navigationDropdown;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void viewUpvoted() {
        upvotedTab.click();
        WebElement recentUpvote = driver.findElement(By.xpath("//*[@id=\"AppRouter-main-content\"]/div/div/div[2]/div[3]/div[1]/div[2]"));
        recentUpvote.click();
        List<WebElement> upvotedList = driver.findElements(By.xpath("//a[@data-click-id=\"body\"]"));
        System.out.println(upvotedList.size());
        //upvotedList.get(0).click(); --> issue here

    }

    @Override
    public boolean isNavigationDropdownExist() {
        return navigationDropdown.isPresent();
    }


}
