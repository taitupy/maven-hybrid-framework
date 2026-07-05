package com.hrmorange;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.annotations.*;
import pageObjects.hrmOrange.PageGenerator;
import pageObjects.hrmOrange.user.DashboardPO;
import pageObjects.hrmOrange.user.HomePO;
import ultilities.ExcelUtils;

@Epic("HRM Orange")
@Feature("Login")
public class Level_06_ParalellTesting_Allure extends BaseTest implements ITest {
    private WebDriver driver;
    private HomePO homePage;
    private DashboardPO dashboardPage;
    private String testName;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        driver.manage().window().maximize();

        // C3 - Page_Generator - Vi tri 1
        homePage = PageGenerator.getUserHomePage(driver);
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return ExcelUtils.getLoginData();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("Login with data driven from Excel, run parallel on multiple browsers")
    @Description("Login to HRM Orange using data sets read from DataTest.xlsx. Each row is run as one Allure test with its own screenshot on failure.")
    @Test(dataProvider = "loginData")
    public void Login(String tcName,
                      String username,
                      String password,
                      String expected) {
        this.testName = tcName;

        homePage.enterToUsernameTextbox(username);
        homePage.enterToPasswordTextbox(password);
        homePage.clickToDashboardPage();

        if ("Dashboard".equals(expected)) {
            dashboardPage = PageGenerator.getUserDashboardPage(driver);
            verifyTrue(dashboardPage.isDashboardPageDisplayed());
            dashboardPage.clickToLogout();
        }

        else if ("Required".equals(expected)) {

            if (username.isEmpty()) {
                verifyEquals(homePage.getNoticeErrorUsername(), "Required");
            }

            if (password.isEmpty()) {
                verifyEquals(homePage.getNoticeErrorPassword(), "Required");
            }
        }

        else if ("Invalid credentials".equals(expected)) {
            verifyEquals(homePage.getNoticeInvalidCredentials(), "Invalid credentials");
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Override
    public String getTestName() {
        return testName;
    }
}
