package com.solvd.laba.qa;

import com.solvd.laba.qa.gui.components.RedditHelpItem;
import com.solvd.laba.qa.gui.pages.common.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;

import static org.testng.Assert.assertTrue;

public class RedditMobileTest implements IAbstractTest, IMobileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public String subreddit_search = Configuration.getRequired("subreddit_search");

    @Test
    @MethodOwner(owner = "nislam")
    @TestPriority(Priority.P2)
    @TestLabel(name = "home page", value={"web", "functional"})
    public void testHomePage() {
        LOGGER.info("[TEST] Open Reddit Home Page");
        SoftAssert softAssert = new SoftAssert();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page was not opened");
        softAssert.assertEquals(homePage.getDriver().getTitle(), "Reddit - Dive into anything");
        assertTrue(homePage.isHeaderExist(), "Header was not found");
        softAssert.assertTrue(homePage.getHeader().isNavMenuButtonExist(), "Navigation hamburger menu does not exist");
        softAssert.assertTrue(homePage.getHeader().isLogoExist(), "Home logo does not exist");
        softAssert.assertTrue(homePage.getHeader().isUseAppButtonExist(), "'Use App' button does not exist");
        softAssert.assertTrue(homePage.getHeader().isSearchIconExist(), "Search expand icon does not exist");
        assertTrue(homePage.isSidebarExist(), "Sidebar was not found");
        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "nislam")
    @TestPriority(Priority.P2)
    @TestLabel(name = "community search bar", value={"web", "functional"})
    public void testCommunitySearchBar() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SoftAssert softAssert = new SoftAssert();

        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page was not opened");
        homePage.clickNavMenuButton();
        homePage.clickSeeMoreResources();
        CommunitiesPageBase communitiesPage = homePage.clickCommunities();
        assertTrue(communitiesPage.isPageOpened(), "Communities page was not opened");
        assertTrue(communitiesPage.isHeaderExist(), "Header does not exist");
        softAssert.assertTrue(communitiesPage.getHeader().isSearchBarExist(), "Search bar does not exist");
        communitiesPage.searchInSearchBar(subreddit_search);
        SearchResultPageBase searchResultPage = communitiesPage.hitEnter();
        assertTrue(searchResultPage.isPageOpened(), "Search results page was not opened");
        searchResultPage.clickCommunitiesTab();
        SubredditPageBase subredditPage = searchResultPage.clickSubreddit(subreddit_search);
        softAssert.assertEquals(subredditPage.getSubredditName(), subreddit_search, "Wrong subreddit was selected");
        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "nislam")
    @TestPriority(Priority.P2)
    @TestLabel(name = "subreddit about specs", value={"web", "regression"})
    public void testSubredditSpecs() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SoftAssert softAssert = new SoftAssert();

        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page was not opened");
        homePage.clickNavMenuButton();
        homePage.clickSeeMoreResources();
        CommunitiesPageBase communitiesPage = homePage.clickCommunities();
        assertTrue(communitiesPage.isPageOpened(), "Communities page was not opened");
        communitiesPage.clickCommunityThatStartWith("G");
        communitiesPage.scrollToCommunity("Genshin_Impact");
        SubredditPageBase subredditPage = communitiesPage.clickCommunity();
        softAssert.assertEquals(subredditPage.getSubredditName(), "r/Genshin_Impact", "Wrong subreddit was selected");
        softAssert.assertTrue(subredditPage.isJoinButtonExist(), "Join button was not found");
        softAssert.assertTrue(subredditPage.isAboutTabExist(), "About button was not found");
        subredditPage.clickAboutTab();
        softAssert.assertNotNull(subredditPage.getSubredditDescription(), "Subreddit description is missing or was not found");
        LOGGER.info(subredditPage.getSubredditName());
        LOGGER.info(subredditPage.getSubredditDescription());
        softAssert.assertTrue(subredditPage.isRulesSectionExist(), "Rules were not found");
        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "nislam")
    @TestPriority(Priority.P2)
    @TestLabel(name = "help page item selection", value={"web", "functional"})
    public void testHelpPageWithItemSelection() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SoftAssert softAssert = new SoftAssert();

        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page was not opened");
        homePage.clickNavMenuButton();
        homePage.clickSeeMoreResources();
        HelpPageBase helpPage = homePage.clickHelp();
        assertTrue(helpPage.isPageOpened(), "Help page was not opened");
        helpPage.chooseHelpItem(RedditHelpItem.REDDIT_101);
        softAssert.assertAll();
    }
}
