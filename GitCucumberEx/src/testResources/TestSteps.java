
package testResources;

import java.io.File;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import cucumber.api.java.en.Then;

public class TestSteps {
	
	private static WebDriver driver;
	
	@Given("^Chrome Browser is running or open$")
	public void given() throws Throwable {
		  			
		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("C:\\SeleniumDrivers\\chromedriver.exe"))
				.usingAnyFreePort()
				.build();
		service.start();
		
		driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
		
		driver.get("http://demo.borland.com/InsuranceWebExtJS/");	
		
	}

	@When("^verify URL$")
	public void when() throws Throwable {
		Assert.assertTrue("URL not valid.", driver.getCurrentUrl().contains("demo.borland.com"));
		System.out.println("Browser URL: " + driver.getCurrentUrl());
	}

	@Then("^keep browser open$")
	public void then() throws Throwable {
	}
	
	@And("^display message$")
	public void and() throws Throwable {
	}
	
	@AfterClass
	void closeDriver() throws InterruptedException {
		Thread.sleep(5000);
		if (driver!=null) {
			driver.quit();
		}
	}
}
