package pageObjects.hrmOrange;

import org.openqa.selenium.WebDriver;
import pageObjects.hrmOrange.admin.AdminDashboardPO;
import pageObjects.hrmOrange.admin.AdminLoginPO;
import pageObjects.hrmOrange.user.*;

public class PageGenerator {
    public static HomePO getUserHomePage(WebDriver driver){
        return new HomePO(driver);
    }

    public static DashboardPO getUserDashboardPage(WebDriver driver){
        return new DashboardPO(driver);
    }

    public static AdminPO getUserPage(WebDriver driver){
        return new AdminPO(driver);
    }

    public static PIMPO getPIMPage(WebDriver driver){
        return new PIMPO(driver);
    }

    public static TimePO getTimePage(WebDriver driver){
        return new TimePO(driver);
    }

    public static AdminDashboardPO getAdminDashboardPage(WebDriver driver){
        return new AdminDashboardPO(driver);
    }

    public static AdminLoginPO getAdminLoginPage(WebDriver driver){
        return new AdminLoginPO(driver);
    }
}
