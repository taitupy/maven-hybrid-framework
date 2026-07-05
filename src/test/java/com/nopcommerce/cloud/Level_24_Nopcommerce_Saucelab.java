//package com.nopcommerce.cloud;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
//import pageObjects.nopCommerce.user.UserHomePageObject;
//import pageObjects.nopCommerce.user.UserLoginPageObject;
//import pageObjects.nopCommerce.user.UserRegisterPageObject;
//
//public class Level_24_Nopcommerce_Saucelab extends BaseTest{
//	WebDriver driver;
//	UserHomePageObject homePage;
//	UserLoginPageObject loginPage;
//	UserRegisterPageObject registerPage;
//	String projectPath = System.getProperty("user.dir");
//	String firstName, lastName, invalidEmail, notFoundEmail,existingEmail, password;
//	UserCustomerInforPageObject myAccountPage;
//	DataUtil fakeData;
//
//	@Parameters({ "browser", "url", "osName" })
//	@BeforeClass
//	public void beforeClass(String browserName, String appUrl, String osName) {
////		driver = getBrowserDriverSaucelab(browserName, appUrl, osName);
//
//		homePage = PageGeneratorManager.getUserHomePage(driver);
//		fakeData = DataUtil.getData();
//
//		firstName = fakeData.getFirstName();
//		lastName = fakeData.getLastName();
//		invalidEmail = "afc@ss@.&%";
//		existingEmail = fakeData.getEmailAddress();
//		notFoundEmail = fakeData.getEmailAddress();
//		password = fakeData.getPassword();
//
//		System.out.println("Pre-condition - Step 01: Click to Register link");
//		registerPage = homePage.openRegisterPage();
//
//		System.out.println("Pre-condition - Step 02: Input to required fields");
//		registerPage.inputToFirstnameTextbox(firstName);
//		registerPage.inputToLastnameTextbox(lastName);
//		registerPage.inputToEmailTextbox(existingEmail);
//		registerPage.inputToPasswordTextbox(password);
//		registerPage.inputToConfirmPasswordTextbox(password);
//
//		System.out.println("Pre-condition - Step 03: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		System.out.println("Pre-condition - Step 04: Verify success message displayed");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
//
//		System.out.println("Pre-condition - Step 05: Click to Logout link");
//		homePage = registerPage.clickToLogoutLink();
//	}
//
//	@Test
//	public void Login_01_Empty_Data() {
//		loginPage = homePage.openLoginPage();
//
//		loginPage.clickToLoginButton();
//
//		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
//	}
//
//	@Test
//	public void Login_02_Valid_Email_Password() {
//		loginPage = homePage.openLoginPage();
//
//		loginPage.inputToEmailTextbox(existingEmail);
//		loginPage.inputToPasswordTextbox(password);
//
//		homePage = loginPage.clickToLoginButton();
//		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
//
//		myAccountPage = homePage.openMyAccountPage();
//	}
//
////	@AfterClass(alwaysRun = true)
////	public void afterClass() {
////		closeBrowserAndDriver();
////	}
//}
