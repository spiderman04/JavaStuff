
package src.test.resources;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class CukeSeleniumTest {
	
	private static WebDriver driver;
	
	@SuppressWarnings("unused")
	@Given("^Chrome Browser is running or openn$")
	public void given() throws Throwable {
		  			
		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("C:\\SeleniumDrivers\\chromedriver.exe"))
				.usingAnyFreePort()
				.build();
		service.start();
		
		driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
	}

	@When("^verify URL$")
	public void when() throws Throwable {
		driver.getCurrentUrl().contains("http://demo");
	}

	@Then("^keep browser open$")
	public void then() throws Throwable {
	}

}
