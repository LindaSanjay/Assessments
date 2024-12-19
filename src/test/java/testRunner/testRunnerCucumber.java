package testRunner;



import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;



@CucumberOptions(
		features="src/test/resources/features",
		glue = {"stepDefinitions"},
		monochrome=true,
		//dryRun = true,
		tags = {"@Smoke"},
		plugin = {"pretty","html:target/htmlReports",
				"json:target/cucumber.json"})

public class testRunnerCucumber extends AbstractTestNGCucumberTests {
	
}
