package pageObjects.hrmOrange.user;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.hrmOrange.PageGenerator;
import pageUIs.hrmOrange.user.SidebarPageUI;

public class SidebarPO extends BasePage {
    WebDriver driver;

    public SidebarPO(WebDriver driver) {
        this.driver = driver;
    }

    /* Only use for Level_08_Page_Navigation */
    public PIMPO openPimPage() {
        waitForElementClickabe(driver, SidebarPageUI.PIM_LINK);
        clickToElement(driver, SidebarPageUI.PIM_LINK);
        return PageGenerator.getPIMPage(driver);
    }

    public TimePO openTimePage() {
        waitForElementClickabe(driver, SidebarPageUI.TIME_LINK);
        clickToElement(driver, SidebarPageUI.TIME_LINK);
        return PageGenerator.getTimePage(driver);
    }

    public AdminPO openAdminPage() {
        waitForElementClickabe(driver, SidebarPageUI.ADMIN_LINK);
        clickToElement(driver, SidebarPageUI.ADMIN_LINK);
        return PageGenerator.getUserPage(driver);
    }

    @Step("OPEN TO ADMIN PAGE")
    public SidebarPO openSidebarLinkByPageName(String pageName) {
        waitForElementClickabe(driver, SidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToElement(driver, SidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);

        switch (pageName){
            case "PIM":
                return PageGenerator.getPIMPage(driver);
            case "Time":
                return PageGenerator.getTimePage(driver);
            case "Admin":
                return PageGenerator.getUserPage(driver);
            default:
                throw new RuntimeException("Page name is not valid!!!s");
        }
    }

    public void openSidebarLinkByPageNames(String pageName) {
        waitForElementClickabe(driver, SidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToElement(driver, SidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
    }

}
