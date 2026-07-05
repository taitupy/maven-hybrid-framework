package com.hrmorange;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.annotations.*;
import pageObjects.hrmOrange.PageGenerator;
import pageObjects.hrmOrange.user.DashboardPO;
import pageObjects.hrmOrange.user.HomePO;
import ultilities.ExcelUtils;
import ultilities.DatabaseUtils;

import java.sql.SQLException;

public class Level_04_DatabaseTesting extends BaseTest implements ITest {
    private WebDriver driver;
    private HomePO homePage;
    private DashboardPO dashboardPage;
    private String admin, employee, username, password;
    private String testName;
//    String browserName;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        driver.manage().window().maximize();

        // C3- Page_Generator - Vi tri 1
        homePage = PageGenerator.getUserHomePage(driver);
//        this.browserName = browserName;

    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return ExcelUtils.getLoginData();
    }

    @Test(dataProvider = "loginData")
    public void Login(String tcName,
                      String username,
                      String password,
                      String expected) throws SQLException {
        this.testName = tcName;
        homePage.enterToUsernameTextbox(username);
        homePage.enterToPasswordTextbox(password);
        homePage.clickToDashboardPage();

        if ("Dashboard".equals(expected)) {
            dashboardPage = PageGenerator.getUserDashboardPage(driver);
            verifyTrue(dashboardPage.isDashboardPageDisplayed());

            DatabaseUtils db = new DatabaseUtils();
            String status = db.getStatus("101");
            verifyEquals(status, "ACTIVE");
            dashboardPage.clickToLogout();
        }

        else if ("Required".equals(expected)) {

            if (username.isEmpty()) {
                verifyEquals(homePage.getNoticeErrorUsername(), "Required"
                );
            }

            if (password.isEmpty()) {
                verifyEquals(homePage.getNoticeErrorPassword(), "Required"
                );
            }
        }

        else if ("Invalid credentials".equals(expected)) {
            verifyEquals(homePage.getNoticeInvalidCredentials(), "Invalid credentials"
            );
        }
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Override
    public String getTestName() {
        return testName;
    }
}
