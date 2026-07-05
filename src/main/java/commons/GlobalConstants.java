package commons;
import java.io.File;

public class GlobalConstants {
	// DEV
	public static final String PORTAL_DEV_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_DEV_URL = "https://admin-demo.nopcommerce.com";
	
	// TESTING
	public static final String PORTAL_TESTING_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_TESTING_URL = "https://admin-demo.nopcommerce.com";
	public static final String DEV_USER_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String OS_NAME = System.getProperty("os.name");
	// Windows/ MAC/ Linux
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs" + File.separator;
	public static final String DRAG_DROP_HTML5= PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String AUTO_IT_SCRIPT= PROJECT_PATH + File.separator + "autoIT";
	public static final String REPORTNG_SCREENSHOT= PROJECT_PATH + File.separator + "reportNGImage" + File.separator;
	
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 20;
	public static final long RETRY_TEST_FAIL = 3;
	
	public static final String BROWSER_USERNAME = "	taitunguyen_J9wBhN";
	public static final String BROWSER_AUTOMATE_KEY = "xAkpjYvqqm7axSCUQPix";
	public static final String BROWSER_STACK_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static final String SAUCELAB_USERNAME = "oauth-nguyentaitupy-561fe";
	public static final String SAUCELAB_AUTOMATE_KEY = "75cddf1b-2c7b-424b-84c8-6c05a9b66ed3";
	public static final String SAUCELAB_URL = "https://" + SAUCELAB_USERNAME + ":" + SAUCELAB_AUTOMATE_KEY + "@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub";
	
	public static final String LAMBDA_USERNAME = "tunguyen96spkt";
	public static final String LAMBDA_ACCESS_KEY = "L9ppibAEJDBf8mx7DED9InjwfuZLmRfIw5jKR3tfhDeZkxHu3p";
	public static final String LAMBDA_URL = "https://" + LAMBDA_USERNAME + ":" + LAMBDA_ACCESS_KEY + "@hub.lambdatest.com/wd/hub";

}
