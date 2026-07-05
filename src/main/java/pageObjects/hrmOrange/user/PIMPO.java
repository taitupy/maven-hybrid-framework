package pageObjects.hrmOrange.user;

import org.openqa.selenium.WebDriver;

public class PIMPO extends SidebarPO {
    private WebDriver driver;

    public PIMPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}