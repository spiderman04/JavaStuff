
package setup_drivers;

import java.io.File;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


/**
 * @author Admin
 *
 */
public class testSetupChomeDriver {

	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		ChromeDriverService service = new ChromeDriverService.Builder()
				 .usingDriverExecutable(new File("C:\\SeleniumDrivers\\chromedriver.exe"))
		         .usingAnyFreePort()
		         .build();
		 service.start();
		
		driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
	}

	@Test
	public void testChromeDriver() {
		
		//verify driver has launched by checking Window Handle
		Set<String> handles = driver.getWindowHandles();
		
		Assert.assertNotNull(handles);
		Assert.assertTrue("Window handle list empty, check WebDriver instance", handles.size() > 0);
		
		for (String wdwHandle : handles) {
			System.out.println("Open window handle: " + wdwHandle);
		}
	}
	
	@After
	public void tearDown() throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}

}
