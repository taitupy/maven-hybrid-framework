package pageObjects.hrmOrange.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.hrmOrange.PageGenerator;
import pageUIs.hrmOrange.admin.AdminDashboardPageUI;
import pageUIs.hrmOrange.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
    WebDriver driver;

    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public AdminDashboardPO clickToLoginButton() {
        waitForElementVisible(driver, AdminDashboardPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminDashboardPageUI.LOGIN_BUTTON);
        return PageGenerator.getAdminDashboardPage(driver);
    }

    public void clickToAccountLink() {
        waitForElementVisible(driver, AdminLoginPageUI.ACCOUNT_LINK);
        clickToElement(driver, AdminLoginPageUI.ACCOUNT_LINK);
    }

    public void clickToLoginLink() {
        waitForElementVisible(driver, AdminLoginPageUI.LOGIN_LINK);
        clickToElement(driver, AdminLoginPageUI.LOGIN_LINK);
    }
}
