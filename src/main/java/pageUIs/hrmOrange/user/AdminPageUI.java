package pageUIs.hrmOrange.user;

public class AdminPageUI {
    public static final String USERNAME_TEXTBOX = "xpath=//div[@class='oxd-form-row']//input[@class='oxd-input oxd-input--active']";
    public static final String USERNAME_ROLE_ADMIN_DROPDOWN = "xpath=//div[contains(@class, 'oxd-select-text') and contains(text(), '-- Select --')]";
    public static final String USERNAME_ROLE_ADMIN = "xpath=//div[@role='option']//span[text()='Admin']";
    public static final String EMPLOYEE_NAME_TEXTBOX = "xpath=//div[@class='oxd-autocomplete-text-input--before']/following-sibling::input";
    public static final String STATUS_DROPDOWN = "xpath=//label[@class='oxd-label' and text()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String STATUS_ENABLE = "xpath=//div[@role='option']//span[text()='Enabled']";
    public static final String SEARCH_BUTTON = "xpath=//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']";
    public static final String ADMIN_SEARCH_SUCCESS_MESSAGE = "xpath=//div[contains(@class, 'orangehrm-vertical-padding')]/span";

}
