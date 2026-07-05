//package com.nopcommerce.user;
//
//import org.aeonbits.owner.ConfigFactory;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import environmentConfig.Environment;
//import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
//import pageObjects.nopCommerce.user.UserHomePageObject;
//import pageObjects.nopCommerce.user.UserLoginPageObject;
//import pageObjects.nopCommerce.user.UserRegisterPageObject;
//import ultilities.DataUtil;
//
//public class Level_22_Fake_Data_Multiple_Environment extends BaseTest{
//	WebDriver driver;
//	Environment environment;
//
//	@Parameters({"browser", "url"})
//	@BeforeClass
//	public void beforeClass(String browserName, String appUrl) {
//		ConfigFactory.setProperty("evn", appUrl);
//		environment = ConfigFactory.create(Environment.class);
//		driver = getBrowserDriverLocal(browserName, environment.appUrl());
//
//		System.out.println(environment.osName());
//		System.out.println(driver.getCurrentUrl());
//	}
//
//	@Test
//	public void Login_01_Empty_Data() {
//
//	}
//
//	@Test
//	public void Login_02_Empty_Data() {
//
//	}
//
//	@Test
//	public void Login_03_Empty_Data() {
//
//	}
//
//	@Test
//	public void Login_04_Empty_Data() {
//
//	}
//
//	@Test
//	public void Login_05_Empty_Data() {
//
//	}
//
//	@AfterClass(alwaysRun = true)
//	public void afterClass() {
//		closeBrowserAndDriver();
//	}
//}
