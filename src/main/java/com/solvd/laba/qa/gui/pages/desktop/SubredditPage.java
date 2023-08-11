package com.solvd.laba.qa.gui.pages.desktop;

import com.solvd.laba.qa.gui.pages.common.SubredditPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SubredditPageBase.class)
public class SubredditPage extends SubredditPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class=\"font-bold text-[18px]\"]")
    private ExtendedWebElement subredditName;

    public SubredditPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getSubredditName() {
        return subredditName.getText();
    }
}
