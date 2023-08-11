package com.solvd.laba.qa.gui.pages.desktop;

import com.solvd.laba.qa.gui.components.footer.FooterMenuBase;
import com.solvd.laba.qa.gui.components.footer.FooterMenuDesktop;
import com.solvd.laba.qa.gui.components.header.HeaderMenuBase;
import com.solvd.laba.qa.gui.components.header.HeaderMenuDesktop;
import com.solvd.laba.qa.gui.pages.common.*;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//span[@data-testid=\"jump-to-content\"]")
    private ExtendedWebElement homeLogo;

    @FindBy(id = "USER_DROPDOWN_ID")
    private ExtendedWebElement userDropdown;

    @FindBy(xpath = "//button[text()=\"Back to Top\"]")
    private ExtendedWebElement backToTopButton;

    @FindBy(xpath = "//input[@name=\"createPost\"]")
    private ExtendedWebElement createPostInput;

    @FindBy(xpath = "//div[@class=\"DraftEditor-editorContainer\"]")
    private ExtendedWebElement commentBox;

    @FindBy(xpath = "//br[@data-text=\"true\"]")
    private ExtendedWebElement commentInput;

    private List<WebElement> postElementsList;
    private List<WebElement> upvoteButtons;
    private List<WebElement> commentSections;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(homeLogo);
    }

    @Override
    public LogInPageBase openLogIn() {
        FooterMenuBase footerMenu = new FooterMenuDesktop(driver);
        footerMenu.openCommunitiesPage();
        CommunitiesPageBase communitiesPage = initPage(driver, CommunitiesPageBase.class);
        communitiesPage.clickLogIn();
        LOGGER.info("Log In pop-up opening");
        return initPage(driver, LogInPageBase.class);
    }

    @Override
    public GetAppPopUpBase openGetApp() {
        HeaderMenuBase headerMenu = new HeaderMenuDesktop(driver);
        headerMenu.openGetApp();
        LOGGER.info("Get App pop-up opening");
        return initPage(driver, GetAppPopUpBase.class);
    }

    @Override
    public AboutPageBase openAboutPage() {
        FooterMenuBase footerMenu = new FooterMenuDesktop(driver);
        footerMenu.openAboutPage();
        LOGGER.info("About Page opening");
        return initPage(driver, AboutPageBase.class);
    }

    @Override
    public HelpPageBase openHelpPage() {
        FooterMenuBase footerMenu = new FooterMenuDesktop(driver);
        footerMenu.openHelpPage();
        LOGGER.info("Help Page opening");
        return initPage(driver, HelpPageBase.class);
    }

    @Override
    public CommunitiesPageBase openCommunitiesPage() {
        FooterMenuBase footerMenu = new FooterMenuDesktop(driver);
        footerMenu.openCommunitiesPage();
        LOGGER.info("Communities Page opening");
        return initPage(driver, CommunitiesPageBase.class);
    }

    @Override
    public void clickBackToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int y = 0;
        for (int i = 0; i < 100; i++) {
            js.executeScript("scroll(0," + y + ")");
            y += 100;
        }
        backToTopButton.click();
    }

    @Override
    public void selectAPost() {
        postElementsList = driver.findElements(By.xpath("//div[@data-adclicklocation=\"title\"]"));
        postElementsList.get(0).click();
        WebElement closeButton = getDriver().findElement(By.xpath("//button[@title=\"Close\"]"));
        closeButton.click();
    }

    @Override
    public ProfilePageBase upvotePost() {
        upvoteButtons = driver.findElements(By.xpath("//button[@aria-label=\"upvote\"]"));
        String pressed = upvoteButtons.get(0).getAttribute("aria-pressed");
        if (pressed.equals("false"))
            upvoteButtons.get(0).click();
        userDropdown.click();
        ExtendedWebElement profile = userDropdown.findExtendedWebElement(By.xpath("//span[text()=\"Profile\"]"));
        profile.click();
        return initPage(driver, ProfilePageBase.class);
    }

    @Override
    public void writeComment() {
        commentSections = driver.findElements(By.xpath("//a[@data-click-id=\"comments\"]"));
        commentSections.get(0).click();
        commentBox.hover();
        commentBox.click();
        commentInput.type("This made my day, thank you!");
    }

    @Override
    public boolean isHomeLogoExist() {
        LOGGER.info("Checking if Home Logo exists");
        return homeLogo.isPresent();
    }

    @Override
    public boolean isUserDropdownExist() {
        return userDropdown.clickIfPresent();
    }

    @Override
    public boolean isCreatePostVisible() {
        return createPostInput.isVisible();
    }

    @Override
    public void open() {
        super.open();
        LOGGER.info("Home is being opened");
    }
}
