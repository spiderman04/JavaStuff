import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;;



/**
 * @author Admin
 *
 */
public class TestAgentSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	private static ChromeDriverService service;
	private WebDriver driver;
	
	@BeforeClass
	public static void createAndStartService() throws IOException {
		 service = new ChromeDriverService.Builder()
				 .usingDriverExecutable(new File("C:\\SeleniumDrivers\\chromedriver.exe"))
		         .usingAnyFreePort()
		         .build();
		 service.start();
	}
	
	
	@Before
	public void setUp() throws InterruptedException {
		 driver = new RemoteWebDriver(service.getUrl(),
				 	DesiredCapabilities.chrome());
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://demo.borland.com/InsuranceWebExtJS//");
		Thread.sleep(5000);  // Let the user actually see something!
		  
	}


	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	 @AfterClass
	 public static void createAndStopService() {
		 service.stop();
	 }
}
