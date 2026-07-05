package pageObjects.hrmOrange.user;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.hrmOrange.user.AdminPageUI;

public class AdminPO extends SidebarPO {
    private WebDriver driver;

    public AdminPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToUsername(String admin) {
        waitForElementVisible(driver, AdminPageUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver, AdminPageUI.USERNAME_TEXTBOX, admin);
    }

    public void clickToUserRole() {
        waitForElementClickabe(driver, AdminPageUI.USERNAME_ROLE_ADMIN_DROPDOWN);
        clickToElement(driver, AdminPageUI.USERNAME_ROLE_ADMIN_DROPDOWN);

        waitForElementClickabe(driver, AdminPageUI.USERNAME_ROLE_ADMIN);
        clickToElement(driver, AdminPageUI.USERNAME_ROLE_ADMIN);
    }

    public void enterToEmployeeName(String employee) {
        waitForElementVisible(driver, AdminPageUI.EMPLOYEE_NAME_TEXTBOX);
        sendkeyToElement(driver, AdminPageUI.USERNAME_TEXTBOX, employee);
    }

    public void clickToStatus() {
        waitForElementClickabe(driver, AdminPageUI.STATUS_DROPDOWN);
        clickToElement(driver, AdminPageUI.STATUS_DROPDOWN);

        waitForElementClickabe(driver, AdminPageUI.STATUS_ENABLE);
        clickToElement(driver, AdminPageUI.STATUS_ENABLE);
    }

    public void clickToSearchButton() {
        waitForElementClickabe(driver, AdminPageUI.SEARCH_BUTTON);
        clickToElement(driver, AdminPageUI.SEARCH_BUTTON);
    }

    @Step("CLICK TO ADMIN SEARCH PAGE")
    public void adminSearchPage(String admin, String employee){
        waitForElementVisible(driver, AdminPageUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver, AdminPageUI.USERNAME_TEXTBOX, admin);

        waitForElementClickabe(driver, AdminPageUI.USERNAME_ROLE_ADMIN_DROPDOWN);
        clickToElement(driver, AdminPageUI.USERNAME_ROLE_ADMIN_DROPDOWN);
        waitForElementClickabe(driver, AdminPageUI.USERNAME_ROLE_ADMIN);
        clickToElement(driver, AdminPageUI.USERNAME_ROLE_ADMIN);

        waitForElementVisible(driver, AdminPageUI.EMPLOYEE_NAME_TEXTBOX);
        sendkeyToElement(driver, AdminPageUI.USERNAME_TEXTBOX, employee);

        waitForElementClickabe(driver, AdminPageUI.STATUS_DROPDOWN);
        clickToElement(driver, AdminPageUI.STATUS_DROPDOWN);
        waitForElementClickabe(driver, AdminPageUI.STATUS_ENABLE);
        clickToElement(driver, AdminPageUI.STATUS_ENABLE);

        waitForElementClickabe(driver, AdminPageUI.SEARCH_BUTTON);
        clickToElement(driver, AdminPageUI.SEARCH_BUTTON);
    }

    public String getSearchValue() {
        waitForElementVisible(driver, AdminPageUI.ADMIN_SEARCH_SUCCESS_MESSAGE);
        return getElementText(driver, AdminPageUI.ADMIN_SEARCH_SUCCESS_MESSAGE);
    }


}
