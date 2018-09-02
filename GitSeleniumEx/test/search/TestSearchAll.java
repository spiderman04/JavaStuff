
package search;

import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;


/**
 * @author Admin
 *
 */
public class TestSearchAll {

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
	public void testSearch() {
		
		try {
			driver.get("http://demo.borland.com/InsuranceWebExtJS/");
			Thread.sleep(5000);  // Let the user actually see something!
			
			Select agentSelect = new Select(driver.findElement(By.name("quick-link:jump-menu")));
			agentSelect.selectByVisibleText("Agent Lookup");
			
			// add a simple text verification
			if ((driver.getTitle().equalsIgnoreCase("InsuranceWeb: Agent Lookup") != true) 
					&& (driver.getTitle() != null) ) {
				System.out.println("Title page does not match!");
				throw new NotFoundException();
			} else {
				System.out.println("Title page does match.");
				
				// click on 'Show all Agents' button
				WebElement btnSearch = driver.findElement(By.id("name-search:search-name"));
				btnSearch.click();
				java.lang.Thread.sleep(3000);
				
				// Find and click on Agent 'Walker'
				java.util.List<WebElement> tableItems = driver.findElements(By.className("x-grid3-row-table"));
				for (WebElement item : tableItems) {
					
					// check if the Agent is listed by cycling thru all web elements
					if (item.getText().contains("Walker")) {
						Actions action = new Actions(driver);
						action.moveToElement(item).perform();
						action.doubleClick(item).perform();
						
						// close the Agent popup dialog
						driver.findElements(By.className("x-tool x-tool-close"));
						break;
					}
				}	
			}
		} catch (NoSuchElementException ex){
			System.out.println("MY EXCEPTION: OBJECT NOT FOUND at " + ex.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	@After
	public void tearDown() throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}

}
