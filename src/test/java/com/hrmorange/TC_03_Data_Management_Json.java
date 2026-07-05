package com.hrmorange;

import commons.BaseTest;
import data.UserData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.hrmOrange.PageGenerator;
import pageObjects.hrmOrange.user.DashboardPO;
import pageObjects.hrmOrange.user.HomePO;

public class TC_03_Data_Management_Json extends BaseTest {
    private WebDriver driver;
    private HomePO homePage;
    private DashboardPO dashboardPage;
    private String admin, employee, username, password;
    private UserData userData;
//    String browserName;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        driver.manage().window().maximize();

        // C3- Page_Generator - Vi tri 1
        homePage = PageGenerator.getUserHomePage(driver);
//        this.browserName = browserName;

        // Tao data test
        userData = UserData.getUser();
    }

    @Test
    public void Login_01_Successful() {
        homePage.enterToUsernameTextbox(userData.getAdmin());
        homePage.enterToPasswordTextbox(userData.getPassword());
        homePage.clickToDashboardPage();
        dashboardPage = PageGenerator.getUserDashboardPage(driver);
        verifyTrue(dashboardPage.isDashboardPageDisplayed());

        dashboardPage.clickToLogout();
        homePage = PageGenerator.getUserHomePage(driver);
    }

    @Test
    public void Login_02_Empty_Data(){
        homePage.enterToUsernameTextbox("");
        homePage.enterToPasswordTextbox("");
        homePage.clickToDashboardPage();
        verifyEquals(homePage.getNoticeErrorUsername(),"Required");
        verifyEquals(homePage.getNoticeErrorPassword(),"Required");
    }

    @Test
    public void Login_03_Invalid_UserName(){
        homePage.enterToUsernameTextbox(userData.getEmployee());
        homePage.enterToPasswordTextbox(userData.getPassword());
        homePage.clickToDashboardPage();
        verifyEquals(homePage.getNoticeInvalidCredentials(),"Invalid credentials");
    }

    @Test
    public void Login_04_Empty_UserName_And_Valid_Password(){
        homePage.enterToUsernameTextbox("");
        homePage.enterToPasswordTextbox(userData.getPassword());
        homePage.clickToDashboardPage();
        verifyEquals(homePage.getNoticeInvalidCredentials(),"Invalid credentials");
    }

    @Test
    public void Login_05_Invalid_Password(){
        homePage.enterToUsernameTextbox(userData.getAdmin());
        homePage.enterToPasswordTextbox(userData.getPassword());
        homePage.clickToDashboardPage();
        verifyEquals(homePage.getNoticeInvalidCredentials(),"Invalid credentials");
    }

    @Test
    public void Login_06_Valid_UserName_And_Empty_Password(){
        homePage.enterToUsernameTextbox(userData.getAdmin());
        homePage.enterToPasswordTextbox("");
        homePage.clickToDashboardPage();
        verifyEquals(homePage.getNoticeErrorPassword(),"Required");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
