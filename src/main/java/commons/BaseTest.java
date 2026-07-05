package commons;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
	private WebDriver driver;

	// LOCAL - THREAD LOCAL
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return threadDriver.get();
	}

	protected final Logger log;

	public BaseTest() {
		log = LogManager.getLogger(getClass());
	}

	// LOCAL - THREAD LOCAL
	protected WebDriver getBrowserDriver(String browserName){
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		switch(browserList){
			case FIREFOX:
				threadDriver.set(new FirefoxDriver());
				break;
			case CHROME:
				threadDriver.set(new ChromeDriver());
				break;
			case EDGE:
				threadDriver.set(new EdgeDriver());
				break;
			default:
				throw new RuntimeException("Browser is not valid.");
		}

		threadDriver.get().get(GlobalConstants.DEV_USER_URL);
		threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		return threadDriver.get();
	}

	protected WebDriver getBrowserDriver(String browserName, String url){
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		switch(browserList){
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case CHROME:
				driver = new ChromeDriver();
				break;
			case EDGE:
				driver = new EdgeDriver();
				break;
			default:
				throw new RuntimeException("Browser is not valid.");
		}

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		return driver;
	}

	protected int generateRandomInt () {
		return new Random().nextInt(99999);
	}

	protected boolean verifyTrue(boolean condition){
		boolean status = true;
		try {
			Assert.assertTrue(condition);
			log.info("---------------------- PASSED -------------------------");
		} catch (Throwable e) {
			status = false;
			log.info("---------------------- FAILED -------------------------");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return status;
	}

	protected boolean verifyFalse(boolean condition){
		boolean status = true;
		try {
			Assert.assertFalse(condition);
			log.info("---------------------- PASSED -------------------------");
		} catch (Throwable e) {
			status = false;
			log.info("---------------------- FAILED -------------------------");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return status;
	}

	protected boolean verifyEquals(Object actual, Object expected){
		boolean status = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("---------------------- PASSED -------------------------");
		} catch (Throwable e) {
			status = false;
			log.info("---------------------- FAILED -------------------------");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return status;
	}
}
