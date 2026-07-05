package factoryBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Architecture;

public class IEDriverManager implements BrowserFactory{
	
	@Override
	public WebDriver getBrowserDriver() {
		if(!IS_OS_WINDOWS){
			throw new BrowserNotSupportedException("IE is not supported on" + System.getProperty("os.name"));
		}
		WebDriverManager.iedriver().architecture(Architecture.X32).setup();
		
		// selenium 2.x
//		DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
//		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		// todo...
		
		// selenium 3.x
		InternetExplorerOptions options = new InternetExplorerOptions();
		// todo...
		
		return new InternetExplorerDriver(options);
	}
}
