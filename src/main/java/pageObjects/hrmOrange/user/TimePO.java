package pageObjects.hrmOrange.user;

import org.openqa.selenium.WebDriver;

public class TimePO extends SidebarPO {
    private WebDriver driver;

    public TimePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}