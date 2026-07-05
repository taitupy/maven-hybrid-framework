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

public class Level_16_AllureReport extends BaseTest {
    private WebDriver driver;
    private HomePO homePage;
    private DashboardPO dashboardPage;
    private AdminPO adminPage;
    private PIMPO pimPage;
    private TimePO timePage;
    private String admin, employee, username, password;
    String browserName;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        driver.manage().window().maximize();

        // C3- Page_Generator - Vi tri 1
        homePage = PageGenerator.getUserHomePage(driver);

        this.browserName = browserName;

        // Tao data test
        admin = "Admin";
        employee= "";
        username= "Admin";
        password = "admin123";
    }

    @Description("Login and go to the Homepage")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void User_01_Login(Method method){
        dashboardPage = homePage.systemLogin(username, password); // Page A: HomePage

        verifyTrue(dashboardPage.isDashboardPageDisplayed());
    }

    @Description("Go to the Admin page")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void User_02_Admin(Method method) {
        adminPage = dashboardPage.clickToAdminPage(); // Dang dung tu Dashboard Page

        adminPage.adminSearchPage(admin, employee);

        verifyEquals(adminPage.getSearchValue(),"(49) Record Found");
    }

    @Description("Go to the Time page")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void User_03_Dynamic_Locator(Method method) {
        // Admin Page -> PIM Page
        pimPage = (PIMPO) adminPage.openSidebarLinkByPageName("PIM");

        // Pim Page -> Time
        timePage = (TimePO) pimPage.openSidebarLinkByPageName("Time");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
