package com.solvd.laba.qa.gui.pages.desktop;

import com.solvd.laba.qa.gui.components.RedditHelpItem;
import com.solvd.laba.qa.gui.pages.common.HelpPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HelpPageBase.class)
public class HelpPage extends HelpPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//ul/li/a/span[@class=\"blocks-item-title\"]")
    private List<ExtendedWebElement> blocksItems;

    public HelpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void chooseHelpItem(RedditHelpItem helpItem)  {
        for (ExtendedWebElement item : blocksItems) {
            if (item.getText().equals(helpItem.getTitle())) {
                item.click();
                break;
            }
        }
    }

    @Override
    public void writeInSearchBar(String input) {
        searchBar.hover();
        searchBar.click();
        searchBar.type(input, 200);
    }
}
