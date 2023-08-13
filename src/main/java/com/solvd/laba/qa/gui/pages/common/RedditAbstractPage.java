package com.solvd.laba.qa.gui.pages.common;

import com.solvd.laba.qa.gui.components.Header;
import com.solvd.laba.qa.gui.components.Sidebar;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class RedditAbstractPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(tagName = "header")
    private ExtendedWebElement headerElement;

    @FindBy(tagName = "reddit-sidebar-nav")
    private ExtendedWebElement sidebarElement;

    private final Header header;
    private final Sidebar sidebar;

    public RedditAbstractPage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
        sidebar = new Sidebar(driver);
    }

    public Header getHeader() {
        return header;
    }

    public Sidebar getSidebar() {
        return sidebar;
    }

    public boolean isHeaderExist() {
        LOGGER.info("Checking if header exists...");
        return headerElement.isPresent();
    }

    public boolean isSidebarExist() {
        LOGGER.info("Checking if sidebar exists...");
        return sidebarElement.isPresent();
    }
}
