package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/features/getincident2.feature", glue = "steps", monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
