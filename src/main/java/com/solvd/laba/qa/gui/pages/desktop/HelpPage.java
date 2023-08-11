package com.solvd.laba.qa.gui.pages.desktop;

import com.solvd.laba.qa.gui.components.enums.RedditHelpItem;
import com.solvd.laba.qa.gui.pages.common.HelpPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.concurrent.TimeUnit;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HelpPageBase.class)
public class HelpPage extends HelpPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//h1[text()=\"Reddit 101\"")
    private ExtendedWebElement header;

    @FindBy(xpath = "//input[@name=\"query\"]")
    private ExtendedWebElement searchBar;

    @FindBy(tagName = "input")
    private ExtendedWebElement checkbox;

    private WebElement blocksList;
    private List<WebElement> blocksItems;

    public HelpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void chooseHelpItem(RedditHelpItem helpItem) throws InterruptedException {
        blocksList = driver.findElement(By.xpath("//ul[@class=\"blocks-list\"]"));
        blocksItems = blocksList.findElements(By.xpath("//li[@class=\"blocks-item\"]"));

        for (WebElement item : blocksItems) {
            WebElement title = item.findElement(By.tagName("a")).findElement(By.className("blocks-item-title"));

            if (title.getText().equals(helpItem.getTitle())) {
                item.click();
                break;
            }
        }
    }

    @Override
    public boolean isCorrectHeader(RedditHelpItem helpItem) {
        return header.isElementWithTextPresent(helpItem.getTitle());
    }

    @Override
    public void writeInSearchBar(String input) {
        searchBar.hover();
        searchBar.click();
        searchBar.type(input, 200);
        searchBar.sendKeys(Keys.ENTER);
    }
}
