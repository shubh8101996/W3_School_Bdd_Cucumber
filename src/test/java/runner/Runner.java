package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "feature/login.feature", glue = "stepDef", dryRun = false, monochrome = true, plugin = {
		"pretty", "html:target/cucumber-reports.html" }, tags = "@run")
public class Runner {

	public static void main(String[] args) {
		
	

	}

}
