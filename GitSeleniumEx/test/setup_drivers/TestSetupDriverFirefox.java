
package setup_drivers;

import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;



/**
 * @author Admin
 *
 */
public class TestSetupDriverFirefox {

	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); //This is the location where you have installed Firefox on your machine
		
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDrivers\\geckodriver.exe");
		driver = new FirefoxDriver(options);
	}

	@Test
	public void testDriverFirefox() {
		
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
