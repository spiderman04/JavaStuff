/* This file was generated with 'selenium-server-standalone-3.11.0.jar' 
 * and accompanying libraries.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestChromeURL {

	public static void main(String[] args) {
		
		// OPTIONAL: Set VM Argument of proper browser executable
		// -Dwebdriver.chrome.driver="C:\path\to\chromedriver.exe"
		
		WebDriver driver = null;
			
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.get("http://demo.borland.com/InsuranceWebExtJS/");			

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
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	} // End main

}
