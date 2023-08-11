package com.solvd.laba.qa;

import com.solvd.laba.qa.gui.RedditProperties;
import com.solvd.laba.qa.gui.components.enums.RedditHelpItem;
import com.solvd.laba.qa.gui.pages.common.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Properties;

public class RedditWebTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    @MethodOwner(owner = "nislam")
    @TestPriority(Priority.P2)
    @TestLabel(name = "home page", value={"web", "functional"})
    public void testOpenHomePage() {
        LOGGER.info("[TEST] Open Reddit Home Page");
        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        softAssert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        softAssert.assertEquals(homePage.getDriver().getTitle(), "Reddit - Dive into anything");
        softAssert.assertTrue(homePage.isHomeLogoExist(), "Home logo was not found");
    }

    @Test
    @MethodOwner(owner = "nislam")
    @TestPriority(Priority.P2)
    @TestLabel(name = "community search bar", value={"web", "functional"})
    public void testCommunitySearchBar() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Properties properties = RedditProperties.getProperties();
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String subreddit = properties.getProperty("subreddit");
        SoftAssert softAssert = new SoftAssert();

        homePage.open();
        CommunitiesPageBase communitiesPage = homePage.openCommunitiesPage();
        SearchResultPageBase searchResultPage = communitiesPage.searchInSearchBar(subreddit);
        List<WebElement> communitiesList = searchResultPage.clickCommunities();
        SubredditPageBase subredditPage = searchResultPage.goToSubreddit(subreddit, communitiesList);
        softAssert.assertEquals(subredditPage.getSubredditName(), subreddit, "Wrong subreddit was selected");
    }

    @Test
    @MethodOwner(owner = "nislam")
    @TestPriority(Priority.P2)
    @TestLabel(name = "log in", value={"web", "functional"})
    public void testLogIn() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Properties properties = RedditProperties.getProperties();
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        SoftAssert softAssert = new SoftAssert();

        homePage.open();
        LogInPageBase logIn = homePage.openLogIn();
        // CHECKS WRONG LOG-IN INFO
        logIn.writeUsername("wrong_username");
        logIn.writePassword(password);
        logIn.clickSubmit();
        softAssert.assertFalse(homePage.isHomeLogoExist(), "Correct log-in information was given");
        // CHECKS RIGHT LOG-IN INFO
        logIn.writeUsername(username);
        logIn.writePassword(password);
        logIn.clickSubmit();
        HomePageBase homePageAfterLogIn = logIn.returnToHomePage();
        softAssert.assertTrue(homePageAfterLogIn.isUserDropdownExist(), "User dropdown does not exist -- log-in was unsuccessful");
    }

    @Test
    @MethodOwner(owner = "nislam")
    @TestPriority(Priority.P2)
    @TestLabel(name = "help page", value={"web", "functional"})
    public void testHelpPage() throws InterruptedException {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SoftAssert softAssert = new SoftAssert();

        // SELECTS ITEM ON PAGE
        homePage.open();
        HelpPageBase helpPage = homePage.openHelpPage();
        helpPage.chooseHelpItem(RedditHelpItem.REDDIT_101);
        softAssert.assertTrue(helpPage.isCorrectHeader(RedditHelpItem.REDDIT_101), "Page was not opened correctly");

        // USES SEARCH BAR
        homePage.open();
        helpPage = homePage.openHelpPage();
        helpPage.writeInSearchBar("What is my cake day?");

        // how to get past verification bot???
    }

    @Test
    @MethodOwner(owner = "nislam")
    @TestPriority(Priority.P2)
    @TestLabel(name = "post interactions", value={"web", "functional"})
    public void testPostInteractions() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Properties properties = RedditProperties.getProperties();
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        SoftAssert softAssert = new SoftAssert();

        homePage.open();
        // LOG IN TO INTERACT
        LogInPageBase logIn = homePage.openLogIn();
        logIn.writeUsername(username);
        logIn.writePassword(password);
        logIn.clickSubmit();
        HomePageBase homePageAfterLogIn = logIn.returnToHomePage();

        // SCROLLS AND CHECKS IF IT RETURNS TO TOP
        homePageAfterLogIn.clickBackToTop();
        softAssert.assertTrue(homePageAfterLogIn.isCreatePostVisible(), "Page did not return to the top as expected");

        // CLICK POST AND UPVOTE
        softAssert.assertTrue(homePageAfterLogIn.isCreatePostVisible(), "Post was not closed properly as expected");
        ProfilePageBase profilePage = homePageAfterLogIn.upvotePost();
        profilePage.viewUpvoted();
        softAssert.assertEquals(profilePage.isNavigationDropdownExist(), "Could not access navigation dropdown as expected");

        // get rid of Allow Notifications pop-up???
    }
}
