/**
 * 
 */
package seleniumTests;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Admin
 *
 */
public class Demo1 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver;
		
		ChromeDriverService service = new ChromeDriverService.Builder()
				 .usingDriverExecutable(new File("C:\\SeleniumDrivers\\chromedriver.exe"))
		         .usingAnyFreePort()
		         .build();
		 service.start();
		
		driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");

		//verify driver has launched by checking Window Handle
		Set<String> handles = driver.getWindowHandles();
		
		Assert.assertNotNull(handles);
		Assert.assertTrue("Window handle list empty, check WebDriver instance", handles.size() > 0);
		
		for (String wdwHandle : handles) {
			System.out.println("Open window handle: " + wdwHandle);
		}
		
		driver.get("http://demo.borland.com/InsuranceWebExtJS/");			
		Thread.sleep(2000);
		
		if (driver != null) {
			driver.quit();
		}
	}
}
