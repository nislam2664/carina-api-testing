package com.solvd.laba.qa;

import com.solvd.laba.qa.gui.RedditProperties;
import com.solvd.laba.qa.gui.common.HomePageBase;
import com.solvd.laba.qa.gui.desktop.HomePage;
import com.solvd.laba.qa.gui.desktop.LogInPopUp;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class RedditWebTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    @MethodOwner(owner = "nislam")
    public void testOpenHomePage() {
        LOGGER.info("[TEST] Open Reddit Home Page");
        SoftAssert softAssert = new SoftAssert();

        HomePage homePage = new HomePage(new ChromeDriver());
        homePage.open();
        softAssert.assertTrue(homePage.isOpen(), "Home page is not opened");
        softAssert.assertEquals(homePage.getDriver().getTitle(), "Reddit - Dive into anything");
    }

    @Test
    @MethodOwner(owner = "nislam")
    public void testLogIn() {
        LOGGER.info("[TEST] Log Into Reddit");
        SoftAssert softAssert = new SoftAssert();
        Properties properties = RedditProperties.getProperties();

        HomePage homePage = new HomePage(new ChromeDriver());
        homePage.open();
        LogInPopUp logIn = homePage.getLogIn();
        logIn.writeUsername(properties.getProperty("username"));
        logIn.writePassword(properties.getProperty("password"));
        logIn.clickLogIn();
        softAssert.assertTrue(homePage.isOpen(), "Was not returned to home page");
        softAssert.assertTrue(homePage.isLoggedIn(), "User was not logged in");
    }
}
