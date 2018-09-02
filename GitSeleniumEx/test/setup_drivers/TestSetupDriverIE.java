
package setup_drivers;

import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


/**
 * @author Admin
 *
 */
public class TestSetupDriverIE {

	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.ie.driver", "C:\\SeleniumDrivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}

	@Test
	public void testDriverIE() {
		
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
