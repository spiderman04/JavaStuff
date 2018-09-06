package testResources;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/testResources"
				, glue="TestSteps"
				, plugin = {"pretty"
						, "html:target/cucumber-htmlreport"
						,"json:target/cucumber-report.json"}
)
public class MyTestRunner {
}