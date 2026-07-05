package pageObjects.hrmOrange.user;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.hrmOrange.PageGenerator;
import pageUIs.hrmOrange.user.DashboardPageUI;

public class DashboardPO extends BasePage {
    private WebDriver driver;

    // Ham lhoi tao - contructor
    // 1 - cung ten vs ten class
    // 2 - khong co kieu tra ve (Data Type)
    // 3 - chay dau tien khi class nay dc goi (new DashboardPageObject)
    // 4 - co tham so or ko
    // 5 - ko tu define ham khoi tao thi JVM se mac dinh tao ra 1 ham khoi tao rong

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("VERIFY MOVE TO DASHBOARD PAGE")
    public boolean isDashboardPageDisplayed() {
        waitForElementVisible(driver, DashboardPageUI.PIM_LINK);
        return isElementDisplayed(driver, DashboardPageUI.PIM_LINK);
    }

    //  Cach chua quan ly Page Generator Manager - C1
//    public void clickToAdminPage() {
//        waitForElementClickable(driver, DashboardPageUI.ADMIN_LINK);
//        clickToElement(driver, DashboardPageUI.ADMIN_LINK);
//    }

    // Viet theo Page Generator Manager -C2
//    public AdminPageObject clickToAdminPage() {
//        waitForElementClickable(driver, DashboardPageUI.ADMIN_LINK);
//        clickToElement(driver, DashboardPageUI.ADMIN_LINK);
//        return new AdminPageObject(driver);
//    }

    // Viet theo Page Generator Manager -C3
    @Step("CLICK TO ADMIN PAGE")
    public AdminPO clickToAdminPage() {
        waitForElementClickabe(driver, DashboardPageUI.ADMIN_LINK);
        clickToElement(driver, DashboardPageUI.ADMIN_LINK);
        return PageGenerator.getUserPage(driver); // vi tri 2 cach 3
    }

    public void clickToLogout() {
        waitForElementClickabe(driver, DashboardPageUI.PATH_TO_LOGOUT);
        clickToElement(driver, DashboardPageUI.PATH_TO_LOGOUT);

        waitForElementClickabe(driver, DashboardPageUI.LOGOUT_LINK);
        clickToElement(driver, DashboardPageUI.LOGOUT_LINK);
    }
}
