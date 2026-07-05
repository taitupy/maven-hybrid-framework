package com.hrmorange;

import commons.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.hrmOrange.PageGenerator;
import pageObjects.hrmOrange.user.*;

import java.lang.reflect.Method;

public class TC_01_LoginPage extends BaseTest {
    private WebDriver driver;
    private HomePO homePage;
    private DashboardPO dashboardPage;
    private String admin, employee, username, password;
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
        admin = "Admin";
        employee= "";
        username= "Admin";
        password = "admin123";
    }

    @Test
    public void Login_01_Successful() {
        homePage.enterToUsernameTextbox(admin);
        homePage.enterToPasswordTextbox(password);
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
        homePage.enterToUsernameTextbox("123tu");
        homePage.enterToPasswordTextbox(password);
        homePage.clickToDashboardPage();
        verifyEquals(homePage.getNoticeInvalidCredentials(),"Invalid credentials");
    }

    @Test
    public void Login_04_Empty_UserName_And_Valid_Password(){
        homePage.enterToUsernameTextbox("");
        homePage.enterToPasswordTextbox(password);
        homePage.clickToDashboardPage();
        verifyEquals(homePage.getNoticeInvalidCredentials(),"Invalid credentials");
    }

    @Test
    public void Login_05_Invalid_Password(){
        homePage.enterToUsernameTextbox(admin);
        homePage.enterToPasswordTextbox("123pass");
        homePage.clickToDashboardPage();
        verifyEquals(homePage.getNoticeInvalidCredentials(),"Invalid credentials");
    }

    @Test
    public void Login_06_Valid_UserName_And_Empty_Password(){
        homePage.enterToUsernameTextbox(admin);
        homePage.enterToPasswordTextbox("");
        homePage.clickToDashboardPage();
        verifyEquals(homePage.getNoticeErrorPassword(),"Required");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
